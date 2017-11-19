<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html >
<head>
<title>left</title>
<base href="http://localhost:8080/KFC/">
<style type="text/css">	
	#div1{
		margin-top:10px;
		text-align:center;
		background-color: coral;
	}

	.btn{
		width:215px;
		height:50px;
		background-color: tomato;
	}
	li{
		line-height:20px;
		margin-bottom:30px
	}
</style>
<script type="text/javascript">
	function myExit(){
		if(confirm("是否确认退出")){
			window.top.location.href="index.do?operate=exits;";//最外层的页面(即Index.jsp)跳转
		}
	}
</script>
</head>
<body>
<div id="div1">
<ul>
	<c:choose>
		<c:when test="${empty categories}">
			<h2>暂无分类</h2>
		</c:when>
	<c:otherwise> 
			<a href="index.do?operate=preMain" target="main">全部商品</a>
			<c:forEach items="${categories}" var="c">
				<li><a href="index.do?operate=preMain&cid=${c.id }" target="main">${c.cname}</a></li>
			</c:forEach>		
		</c:otherwise>
	</c:choose>
</ul>	
</div>	
<div id="cartItem">
	<a href="cart.do?operate=cartInfo" target="main"><input type="button" name="cartitem" value="查看购物车" class="btn"/></a>
	<input type="button" name="orderBean" value="查看订单详情" class="btn"/>
	<input type="button" value="退出" class="btn" onclick="myExit()"/>
</div>     
</body>
</html>

