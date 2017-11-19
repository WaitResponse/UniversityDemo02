package com.gem.fruit.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gem.fruit.dao.FruitDAO;
import com.gem.fruit.dao.FruitDAOImpl;
import com.gem.fruit.pojo.Fruit;

public class DetailServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");
		if(idStr!=null && !"".equals(idStr)){
			int id = Integer.parseInt(idStr);
			FruitDAO fruitDAO = new FruitDAOImpl();
			Fruit fruit = fruitDAO.getFruit(id);
			request.setAttribute("fruit", fruit);
			//response.sendRedirect("detail.jsp");
			request.getRequestDispatcher("detail.jsp").forward(request, response);
		}
	}
	
}
