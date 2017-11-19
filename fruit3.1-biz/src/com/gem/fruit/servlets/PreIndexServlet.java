package com.gem.fruit.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gem.fruit.biz.FruitBiz;
import com.gem.fruit.biz.Impl.FruitBizImpl;
import com.gem.fruit.pojo.Fruit;
import com.gem.fruit.util.StringUtil;

public class PreIndexServlet extends HttpServlet {
	
	private FruitBiz fruitBiz=new FruitBizImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		HttpSession session = request.getSession() ;
		int currPage = 0 ;
		String keyword = null ;
		String currPageStr = request.getParameter("currPage");
		if(StringUtil.isEmpty(currPageStr)){//刚进来的，request中没有currPage
			currPage = 1 ;//所以当前是第一页
		}else{
			currPage = Integer.parseInt(currPageStr);
		}
		Object keywordObj = session.getAttribute("keyword");
		if(keywordObj!=null){
			keyword = (String)keywordObj ;
		}else{
			keyword = "" ;//刚进来keywordObj是null
		}
		int pageSize = 5 ;
		int pageCount=fruitBiz.getPageCount(keyword, pageSize);	//通过关键字，和每页显示记录数来获取总页数
		session.setAttribute("pageCount", pageCount);
		
		if(currPage>pageCount){//如果当前页码大于总页码数，当前页码数--，在删除的时候，当删到最后一页没有记录的时候，自动返回上一页
			currPage--;
		}

		session.setAttribute("currPage", currPage);
		
		List<Fruit> fruitList = fruitBiz.getFruitList(keyword, pageSize, currPage);
		session.setAttribute("fruitList", fruitList);
		response.sendRedirect("index.jsp");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)//处理查询请求
			throws IOException, ServletException {
		HttpSession session = request.getSession() ;
		int currPage = 1 ;
		request.setCharacterEncoding("UTF-8");
		String keyword = request.getParameter("keyword");
		session.setAttribute("keyword", keyword);
		
		int pageSize = 5 ;	
		int pageCount =fruitBiz.getPageCount(keyword, pageSize);
		session.setAttribute("pageCount", pageCount);

		if(currPage>pageCount){
			currPage--;
		}

		session.setAttribute("currPage", currPage);

		List<Fruit> fruitList = fruitBiz.getFruitList(keyword, pageSize, currPage);
				
		session.setAttribute("fruitList", fruitList);
		response.sendRedirect("index.jsp");
	}
}
/*
JSP中有9大内置对象：session,request,response,out,application
内置对象：在jsp中不需要new，而能够直接使用的对象就是内置对象

*/