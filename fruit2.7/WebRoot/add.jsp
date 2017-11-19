<%@page import="com.gem.fruit.pojo.Fruit"%>
<%@page import="com.gem.fruit.dao.Impl.FruitDAOImpl"%>
<%@page import="com.gem.fruit.dao.FruitDAO"%>
<%@page contentType="text/html;charset=utf-8"%>
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
			margin-top:100px;
			height:60%;
			margin-top:100px;
			background-color: lightsteelblue;
		}
		html,body{
			margin:0;
			padding:0;
			height:100%;
			background-color: lemonchiffon;
		}
		#tbl{
			border-collapse:collapse;
			border-spacing:0;
			border:1px solid gray;
			width:60%;
			margin-left:20%;
			margin-top:50px;
		}
		#tbl tr{
			text-align: center;
			height:25px;
		}
	
		.back_link{
			border:0px solid red;
			text-align: center;
			float:left;
			margin-right:10px;
			margin-top:5px;
		}
		</style>
</head>
<body>
	<div id="div0">
		<div class="back_link"><a href="index.jsp">返回</a>
		</div>
		<form action="add_do.jsp" method="post">
			<table id="tbl" border="1">
				<caption>添加水果信息</caption>
				<tr>
					<th>名称:</th>
					<td>
					<input type="text" name="fname" />
					</td>
				</tr>
				<tr>
					<th>单价:</th>
					<td>
					<input type="text" name="price"/>
					</td>	
				</tr>
				<tr>
					<th>数量:</th>
					<td>
					<input type="text" name="count" />
					</td>
				</tr>
				<tr>
					<th>备注:</th>
					<td>
					<input type="text" name="remark" />
					</td>
				</tr>
				<tr>
					<th colspan="2">
						<input type="submit" value="添加"/>
						<input type= "reset" value="重置"/>					
					</th>			
				</tr>
			</table>		
		</form>	
	</div>	
</body>
</html>