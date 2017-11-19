package com.gem.fruit.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gem.fruit.dao.FruitDAO;
import com.gem.fruit.dao.FruitDAOImpl;
import com.gem.fruit.pojo.Fruit;
import com.gem.fruit.util.StringUtil;

public class PreIndexServlet extends HttpServlet {
	
	private FruitDAO fruitDAO = new FruitDAOImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession() ;
		int currPage = 0 ;
		String keyword = null ;
		String currPageStr = request.getParameter("currPage");
		if(StringUtil.isEmpty(currPageStr)){
			currPage = 1 ;
		}else{
			currPage = Integer.parseInt(currPageStr);
		}
		Object keywordObj = session.getAttribute("keyword");
		if(keywordObj!=null){
			keyword = (String)keywordObj ;
		}else{
			keyword = "" ;
		}

		int count = fruitDAO.getFruitsCount(keyword);
		int pageSize = 5 ;
		int pageCount = ( count + pageSize - 1 ) / pageSize ;
		session.setAttribute("pageCount", pageCount);

		if(currPage>pageCount){
			currPage--;
		}

		session.setAttribute("currPage", currPage);

		List<Fruit> fruitList = fruitDAO.getFruitList(keyword , pageSize, currPage);
		session.setAttribute("fruitList", fruitList);
		response.sendRedirect("index.jsp");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession() ;
		int currPage = 1 ;
		request.setCharacterEncoding("UTF-8");
		String keyword = request.getParameter("keyword");
		session.setAttribute("keyword", keyword);
		
		int count = fruitDAO.getFruitsCount(keyword);
		int pageSize = 5 ;
		int pageCount = ( count + pageSize - 1 ) / pageSize ;
		session.setAttribute("pageCount", pageCount);

		if(currPage>pageCount){
			currPage--;
		}

		session.setAttribute("currPage", currPage);

		List<Fruit> fruitList = fruitDAO.getFruitList(keyword , pageSize, currPage);
		session.setAttribute("fruitList", fruitList);
		response.sendRedirect("index.jsp");
	}
}
/*
JSP中有9大内置对象：session,request,response,out,application
内置对象：在jsp中不需要new，而能够直接使用的对象就是内置对象

*/