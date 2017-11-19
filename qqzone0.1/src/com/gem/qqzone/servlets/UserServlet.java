package com.gem.qqzone.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gem.qqzone.biz.UserBiz;
import com.gem.qqzone.biz.impl.UserBizImpl;
import com.gem.qqzone.pojo.User;

public class UserServlet extends HttpServlet {
	
	private UserBiz userBiz = new UserBizImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operate = request.getParameter("operate");
		if("login".equals(operate)){
			login(request ,response);
		}
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loginId = request.getParameter("loginId");
		String pwd = request.getParameter("pwd");
		User user = userBiz.login(loginId, pwd);
		if(user!=null){
			request.getSession().setAttribute("currUser", user);
			response.sendRedirect("index.do?operate=preIndex");
		}
	}

}
