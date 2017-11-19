package com.gem.javaee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gem.javaee.pojo.User;


public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		if("lina".equals(uname)&&"ok".equals(pwd)){
			User currUser=new User(uname,pwd);
			request.getSession().setAttribute("currUser", currUser);
			response.sendRedirect("index.jsp");
		}else{
			response.sendRedirect("login.jsp");
		}
	}

}
