<%@ page contentType="text/html;charset=utf-8"%>

E:<%=request.getAttribute("E")%>

<!-- 
小结：
	page作用域：仅仅在本页面有效
	request作用域：在一次请求响应的过程有效（这里面可能会在服务端跳转多个页面）

	客户端重定向：地址栏会变化，request作用域的值获取不到
	服务器端转发：地址栏不会变化，request作用域的值可以获取到（虽然跨多个页面，但是都是在服务器内部转发的，仍然属于一次请求响应）
	
 -->