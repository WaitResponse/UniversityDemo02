<%@ page contentType="text/html;charset=utf-8"%>
<%@page import="com.gem.kfc.pojo.User"%>
<%@page import="com.gem.kfc.dao.Impl.UserDAOImpl"%>
<%@page import="com.gem.kfc.dao.UserDAO"%>
<% 
	//1.获取loginId,pwd
		String loginId=request.getParameter("loginId");
		String pwd=request.getParameter("pwd");
	//2.验证用户是否存在
		UserDAO userDAO=new UserDAOImpl();
		User user=userDAO.getUser(loginId,pwd);
		if(user!=null){
			session.setAttribute("user", user);
			response.sendRedirect("pre_index");
		}else{
			out.println("<script language='javascript'>");
			out.println("alert('用户不存在或密码错误!');");
			out.println("window.history.back();");
			out.println("</script>");
		}

%>