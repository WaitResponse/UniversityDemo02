package com.gem.javaee.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter2 implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		HttpSession session=request.getSession();
		
		String servletPath=request.getServletPath();
		boolean flag=false;
		for(int i=0;i<bai.length;i++){
			String baiStr=bai[i];
			if(baiStr.equals(servletPath)){
				flag=true;
				break;
			}			
		}
		if(flag){
			System.out.println("拦截了");
			chain.doFilter(request, response);
			System.out.println("放行了");
		}else{
			Object currUserObj=session.getAttribute("currUser");
			if(currUserObj==null){
				response.sendRedirect("login2.jsp");
			}else{
				chain.doFilter(request, response);
			}
		}
		
	}
	
	public void init(FilterConfig config) throws ServletException {
		String baiStr=config.getInitParameter("bai");
		bai=baiStr.split(",");
		
	}
	String[]bai;
}
