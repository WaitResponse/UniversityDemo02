<%@page contentType="text/html; charset=utf-8"%>
<%@page import="java.util.List" %>
<%@page import="com.gem.fruit.dao.Impl.FruitDAOImpl"%>
<%@page import="com.gem.fruit.dao.FruitDAO"%>
<%@page import="com.gem.fruit.pojo.Fruit"%>
<html>
	<head>
		<style type="text/css">
		*{
			font-size:15px;
			color:coral;
		}
		#tbl{
			border-collapse: collapse;
			border-spacing:0;
			border;1px solid gray;
			width:80%;
			margin-left:10%;
			margin-top:50px;
		}
		#div0{
			float:left;
			width:60%;
			height:60%;
			margin-left:20%;
			margin-top:100px;	
			border:1px solid gray;		
			background-color: lightcyan;
		} 
		#tbl tr{
			text-align: center;
			heigth:30px;
		}
		.btn{
			width:50px;
			height:20px;
			border:0;
			background-color: ghostwhite;
			color:black;
		}
	html,body{
		margin:0;
		padding:0;
		height:100%;
		background-color: pink;	
	}
	
	</style>
	<script type="text/javascript">
		function delFruit(fid){
			if(confirm('是否删除?')){
				window.location.href="del.jsp?fid="+fid;
			}
		}
		
	</script>
	</head>
<body>
	<div id="div0">
		<table border="1" id="tbl">
			<caption>水果列表</caption>
			<tr>
				<th width="25%">名称</th>
				<th width="25%">单价</th>
				<th width="25%">数量</th>
				<th>操作</th>	
			</tr>
<%
		FruitDAO fruitDAO =new FruitDAOImpl();
		List<Fruit>fruitList=fruitDAO.getFruitList();
		if(fruitList==null||fruitList.size()<=0){
%>
				<tr>
					<th colspan="4">对不起，没有任何数据！</th>
				</tr>
<%
		}else{
			for(int i=0;i<fruitList.size();i++){
				Fruit fruit =fruitList.get(i);
%>
		<tr>
			<td>
			<a href="detail.jsp?id=<%=fruit.getId()%>">
			<%=fruit.getName() %></a></td>
			<td><%=fruit.getPrice() %></td>
			<td><%=fruit.getCount() %></td>
			<td><input type="button" value="删除" class="btn" fid
			="<%=fruit.getId()%>" onclick="delFruit(<%=fruit.getId()%>)"
			/></td>
		</tr>
<%
			}							
		}
%>
		</table>
	</div>
 </body>
</html>
