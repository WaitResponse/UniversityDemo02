<%@page contentType="text/html; charset=utf-8" %>
<%
	boolean flag=session.isNew();
	System.out.println(flag?"新会话":"旧回话");

%>
<hr/>
<a href="H.jsp">Page H</a>