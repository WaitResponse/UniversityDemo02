<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<!-- <base href="http://localhost:8080/KFC/">   -->
	<link rel="stylesheet" type="text/css" href="css/common.css"/>
	<link rel="Stylesheet" type="text/css" href="css/to_pay.css"/>
	<style type="text/css">
		.hidden type={
			display:none;
		}
		.showTR{
			display:block;
		}
	</style>
	<script type="text/javascript">
	function showOrDisplayTR(){
		var a = document.getElementById("showOrHiddenAddrLink");
		var myValue = a.getAttribute("myValue");
		var className = "showTR" ;
		if(myValue==1){
			className = "showTR";
		}else{
			className = "hiddenTR";
		}
		var tbl = document.getElementById("nonDefaultAddTbl");
		tbl.className = className;
		tbl.style.marginLeft="15%";
		myValue = myValue * (-1);
		a.setAttribute("myValue",myValue);
	};
	</script>
</head>
<body>
	<div id="div0">
		<table class="tbl" >
			<tr>
				<th>序号</th>		
				<th>名称</th>	
				<th>单价</th>
				<th>购买数量</th>
				<th>小计</th>	
			</tr>
		<c:choose>
			<c:when test="${not empty cartItemMap }">
				<c:set var="i" value="0"/>
				<c:set var="sum" value="0"/>
				<c:forEach items="${cartItemMap}" var="car">
					<c:set var="i" value="${i+1}"/>
					<c:set var="sum" value="${sum+car.value.count *car.value.goods.price}"/>
					<tr align="center">
						<td>${i}</td>
						<td>${car.value.goods.gname }</td>
						<td>${car.value.goods.price}</td>
						<td>${car.value.count}</td>
						<td>${car.value.goods.price*car.value.count}</td>						
					</tr>				
				</c:forEach>
				<tr id="last">
					<td>总计</td>
					<td colspan="4">${sum}</td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<th colspan="5">购物车为空</th>
				</tr>
			</c:otherwise>		
		</c:choose>	
		</table>	
		<hr/>
		<form action="cart.do?operate=Pay" method="post">
			<table class="tbl">
				<tr>
					<th width="20%">序号</th>
					<th width="20%">收货人</th>
					<th width="40%">收货地址</th>
					<th width="20%">收货电话</th>
				</tr>
				<c:choose>
					<c:when test="${not empty address}">
						<c:forEach items="${address}" var="a">
							<c:if test="${a.defaultAddressFlag}">
								<tr>
									<td>
										<input type="radio" name="addr" value="${a.id }" checked/>
									</td>
									<td>${a.uname }</td>
									<td>${a.address}</td>
									<td>${a.tel}</td>
								</tr>
							</c:if>
						</c:forEach>			
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="4"><a href="#">
								你没有收货地址!,添加一个?
							</a></td>
						</tr>
					</c:otherwise>
				</c:choose>
			</table>
			<a id="showOrHiddenAddrLink" href="javascript:showOrDisplayTR();" myValue="1">展开其他地址</a>
			<table class="tbl hiddenTR" id="nonDefaultAddTbl">
				<c:forEach items="${address}" var="a">
					<c:if test="${!a.defaultAddressFlag}">
						<tr align="center">
							<td width="20%"><input type="radio" name="addr" value="${a.id}"/></td>
							<td width="20%">${a.uname }</td>
							<td width="40%">${a.address}</td>
							<td width="20%">${a.tel }</td>
						</tr>
					</c:if>
				</c:forEach>
			</table>
			<hr/>
			<div id="checkout">
				<input type="submit" value="确认下单"/>
			</div>
		</form>
		</div>
</body>
</html>