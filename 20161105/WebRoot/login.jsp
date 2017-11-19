<%@page contentType="text/html; charset=utf-8" %>

<form action="login.action" method="post" >
	用户名<input type="text" name="uname"/><br/>
	密码<input type="password" name="pwd"/><br/>
	<input type="submit" value="登录"/>
</form>
<%
	System.out.println("login.jsp页面执行完成。。。");
%>