<%@page contentType="text/html; charset=utf-8" %>
<h1>PageH</h1>
<%=session.isNew()%>
<br/>
<h2>sessionID:<%=session.getId() %></h2>	
<hr/>
<% 
	//session.setMaxInactiveInterval(10);
%>
<%
	session.invalidate();
%>