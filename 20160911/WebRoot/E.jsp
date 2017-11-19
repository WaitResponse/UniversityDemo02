<%@ page contentType="text/html;charset=utf-8"%>

<%
String E = "E";
//向request作用域保存这个值
request.setAttribute("E", E);
%>
<hr/>

E:<%=request.getAttribute("E")%>
<hr/>
<a href="F.jsp">Page F</a>
<%
	//response.sendRedirect("F.jsp");
	request.getRequestDispatcher("F.jsp").forward(request,response);
%>