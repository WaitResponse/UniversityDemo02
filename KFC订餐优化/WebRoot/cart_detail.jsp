<%@page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/common.css">
	<link rel="stylesheet" type="text/css" href="css/cart_detail.css">
	<script type="text/javascript">
		function todel(gid){
			if(confirm('是否删除')){
				window.location.href="cart.do?operate=delcart&gid="+gid;
			}
		
		}
	</script>
</head>
<body>
	<div id="div0">
		<table class="tbl">
			<tr>
				<th>序号</th>		
				<th>名称</th>	
				<th>单价</th>
				<th>购买数量</th>
				<th>小计</th>
				<th>删除</th>			
			</tr>
		<c:choose>
			<c:when test="${not empty cartItemMap }">
				<c:set var="i" value="0"/>
				<c:forEach items="${cartItemMap}" var="car">
					<c:set var="i" value="${i+1}"/>
					<tr align="center">
						<td>${i}</td>
						<td>${car.value.goods.gname }</td>
						<td>${car.value.goods.price}</td>
						<td>${car.value.count}</td>
						<td>${car.value.goods.price*car.value.count}</td>
						<td><input type="button" value="删除" onclick="todel(${car.value.goods.id})"/></td>
					</tr>				
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<th colspan="6">您没有购买任何商品</th>
				</tr>
			</c:otherwise>		
		</c:choose>	
		</table>	
		<div id="div1">
			<a href="cart.do?operate=prePay"><input type="button" class="btn" value="去结账" /></a>
		</div>	
	</div>
</body>

</html>