package com.gem.fruit.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gem.fruit.dao.FruitDAO;
import com.gem.fruit.dao.FruitDAOImpl;

public class DelServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession() ;
		String fidStr = request.getParameter("fid");
		if(fidStr==null || "".equals(fidStr)){
			response.sendRedirect("preIndex.html");
		}else{
			int id = Integer.parseInt(fidStr);
			FruitDAO fruitDAO = new FruitDAOImpl();
			fruitDAO.delFruit(id);
			Object currPageObj = session.getAttribute("currPage");
			int currPage = 0 ;
			if(currPageObj==null){
				currPage = 1 ;
			}else{
				currPage = (Integer)currPageObj ;
			}
			response.sendRedirect("preIndex.html?currPage="+currPage);
		}
	}
	
}
