<%@page import="com.gem.fruit.pojo.Fruit"%>
<%@page import="java.util.List"%>
<%@page import="com.gem.fruit.dao.FruitDAOImpl"%>
<%@page import="com.gem.fruit.dao.FruitDAO"%>
<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<style type="text/css">
			*{
				font-size:12px;
				color:#008080;
			}
			#div0{
				float:left;
				width:60%;
				margin-left:20%;
				height:60%;
				margin-top:100px;
				background-color:menu;
			}
			html , body{
				margin:0;
				padding:0;
				height:100%;
				background-color:#C0C0C0;
			}
			#tbl{
				border-collapse: collapse;
				border-spacing: 0;
				border:1px solid gray;
				width:60%;
				margin-left:20%;
				margin-top:50px;
			}
			#tbl tr{
				text-align:center;
				height:25px;
			}
			.back_link{
				border:0px solid red;
				text-align:right;
				margin-right:10px;
				margin-top:5px;
			}
		</style>
	</head>
	<body>
		<div id="div0">
		<div class="back_link"><a href="index.jsp">返回</a></div>
		<c:choose>
			<c:when test="${empty fruit }">
				<h2 style="color:red;">对不起，没有找到相关记录！</h2>
			</c:when>
			<c:otherwise>
				<form action="update.html" method="post">
					<input type="hidden" name="id" value="${fruit.id }"/>
					<table id="tbl" border="1">
						<caption>编辑水果信息</caption>
						<tr>
							<th>名称：</th>
							<td><input type="text" name="fname" value="${fruit.fname }"/></td>
						</tr>
						<tr>
							<th>单价：</th>
							<td><input type="text" name="price" value="${fruit.price }"/></td>
						</tr>
						<tr>
							<th>数量：</th>
							<td><input type="text" name="count" value="${fruit.count }"/></td>
						</tr>
						<tr>
							<th>备注：</th>
							<td><input type="text" name="remark" value="${fruit.remark }"/></td>
						</tr>
						<tr>
							<th colspan="2">
								<input type="submit" value="修改"/>
								<input type="reset" value="重置"/>
							</th>
						</tr>
						
					</table>
				</form>
			</c:otherwise>
		</c:choose>
		</div>
	</body>
</html>















