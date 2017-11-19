package com.gem.fruit.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gem.fruit.biz.FruitBiz;
import com.gem.fruit.biz.Impl.FruitBizImpl;
import com.gem.fruit.pojo.Fruit;

public class DetailServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");
		if(idStr!=null && !"".equals(idStr)){
			int id = Integer.parseInt(idStr);
			FruitBiz fruitBiz=new FruitBizImpl();
			Fruit fruit = fruitBiz.getFruit(id);
			request.setAttribute("fruit", fruit);
			//response.sendRedirect("detail.jsp");
			request.getRequestDispatcher("detail.jsp").forward(request, response);
		}
	}
	
}
