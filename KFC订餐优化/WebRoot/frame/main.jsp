<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<base href="http://localhost:8080/KFC/">
		<link rel="stylesheet" type="text/css" href="css/main.css">	
		<link rel="stylesheet" type="text/css" href="css/common.css">
		<style type="text/css">
			body{
				background-color: blanchedalmond;
			}	
		</style>
		<script type="text/javascript">
		function addCart(gid){			
			window.location.href="cart.do?operate=toAddCart&gid="+gid;
		}		
		</script>
	</head>
	<body>
		<div id="div0">
			<table class="tbl">
				<c:choose>
					<c:when test="${empty goodses }" >
						暂无商品!
					</c:when>	
					<c:otherwise>
						<c:set var="index" value="0"/>
						<c:forEach items="${goodses}" var="g">
							<c:set var="index" value="${index+1}"/>
						<c:if test="${index%4==1}">
							<tr>
						</c:if>
							<td>
								<table border="1" class="tbl2">
									<tr>
										<td>
											<img alt="${g.gname}" src="${g.img}">
										</td>
									</tr>
									<tr>
										<td class="gname_style">
											${g.gname}&nbsp;￥${g.price}
										</td>										
									</tr>
									<tr>
										<td>
											<input type="button" class="btn" name="inCartItem" value="加入购物车" onclick="addCart(${g.id})"/>
										</td>
									</tr>
								</table>
							</td>
						<c:if test="${index%4==0}">
							</tr>
						</c:if>
					</c:forEach>
					<c:if test="${index%4!=0}">
						</tr>
					</c:if>
					</c:otherwise>		
				</c:choose>			
			</table>		
		</div>
	</body>
</html>