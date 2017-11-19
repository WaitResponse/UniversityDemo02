<%@page contentType="text/html; charset=utf-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name=request.getParameter("uname");
	String []hobbyArr=request.getParameterValues("hobby");
%>

	<h1><%=name%></h1>
	<h1>
	<%
		for(int i=0;i<hobbyArr.length;i++){
	%>
			<%=hobbyArr[i]%>
	<%
		}
	%>
	
	</h1>


