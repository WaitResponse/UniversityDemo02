<%@ page contentType="text/html;charset=utf-8"%>

<h1>Page C</h1>

<%
//客户端重定向
//response.sendRedirect("D.jsp");
//服务器端转发
request.getRequestDispatcher("D.jsp").forward(request, response);

%>