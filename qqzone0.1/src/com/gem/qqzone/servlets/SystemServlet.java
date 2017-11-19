package com.gem.qqzone.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class SystemServlet extends HttpServlet{

	@Override
	public void init(ServletConfig config) throws ServletException {
		String cxtPath = config.getServletContext().getContextPath();
		String baseURL = "http://localhost:8080"+cxtPath +"/";
		config.getServletContext().setAttribute("baseURL", baseURL);
	}
	
}
