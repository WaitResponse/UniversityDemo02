package com.gem.kfc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gem.kfc.dao.UserDAO;
import com.gem.kfc.dao.Impl.UserDAOImpl;
import com.gem.kfc.pojo.User;

public class LoginServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charSet=utf-8");
		String operate=request.getParameter("operate");
		if(operate.equals("loginDo")){
			loginDo(request,response);
		}else if(operate.equals("registDo")){
			registDo(request,response);
		}
		
	}
	private void loginDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.��ȡloginId,pwd
		HttpSession session=request.getSession();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charSet=utf-8");
		PrintWriter out=response.getWriter();
		
		String loginId=request.getParameter("loginId");
		String pwd=request.getParameter("pwd");
	//2.��֤�û��Ƿ����
		UserDAO userDAO=new UserDAOImpl();
		User user=userDAO.getUser(loginId,pwd);
		if(user!=null){
			session.setAttribute("currUser", user);
			response.sendRedirect("index.do?operate=preIndex");	
		}else{
			out.println("<script language='javascript'>");
			out.println("alert('�û������ڻ��������!');");
			out.println("window.history.back();");
			out.println("</script>");
		}
	}

	private void registDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			
	}
	
}
