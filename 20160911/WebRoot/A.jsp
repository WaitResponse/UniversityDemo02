<%@ page contentType="text/html;charset=utf-8"%>

<% 
	String A="我是你爹";
	pageContext.setAttribute("B", A);//将A保存到page的“A”中
%>
<hr/>
A:<%=pageContext.getAttribute("B") %>
<hr/>
<a href="B.jsp">page B</a>