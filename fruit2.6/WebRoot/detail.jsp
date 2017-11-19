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
<%
	Object fruitObj=request.getAttribute("fruit");
	if(fruitObj==null){
%>		
		<h2 style="color:red;">对不起，没有找到相关记录</h2>
<% 
		}else{
			Fruit fruit=(Fruit)fruitObj;
%>
		<form action="update.jsp" method="post">
			<input type="hidden" name="id" value="<%=fruit.getId() %>"/>
			<table id="tbl" border="1">
				<caption>编辑水果信息</caption>
				<tr>
					<th>名称:</th>
					<td>
					<input type="text" name="fname" value="<%=fruit.getName()%>"/>
					</td>
				</tr>
				<tr>
					<th>单价:</th>
					<td>
					<input type="text" name="price" value="<%=fruit.getPrice()%>"/>
					</td>	
				</tr>
				<tr>
					<th>数量:</th>
					<td>
					<input type="text" name="count" value="<%=fruit.getCount()%>"/>
					</td>
				</tr>
				<tr>
					<th>备注:</th>
					<td>
					<input type="text" name="remark" value="<%=fruit.getRemark()%>"/>
					</td>
				</tr>
				<tr>
					<th colspan="2">
						<input type="submit" value="修改"/>
						<input type= "reset" value="重置"/>					
					</th>			
				</tr>
			</table>		
		</form>
<%
		}	
%>
		
	</div>
		
</body>
</html>