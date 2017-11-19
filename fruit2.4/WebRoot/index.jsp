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
			background-color:forestgreen ;
			color:black;
		}
	html,body{
		margin:0;
		padding:0;
		height:100%;
		background-color: pink;	
	}
	.no_underline{
		text-decoration: none;
	}
	#page_div{
		border:0px solid red;
		text-align:center;
		padding-top:4px;
		padding-bottom:4px;
	}
	input[class="btn"][disabled]{
		background-color: gray;
	}
	</style>
	<script type="text/javascript">
		function delFruit(fid){//这里表示如果点击了"是"，则跳转到del.jsp
			if(confirm('是否删除?')){
				window.location.href="del.jsp?fid="+fid;
			}
		}
		function toPage(pageNum){
			window.location.href="pre_index.jsp?currPage="+pageNum;
		}
	</script>
	</head>
<body>
	<div id="div0">
	<div style="text-align:right;padding-right:30px;">
	<a class="no_underline" href="add.jsp">添加新水果</a>
	</div>
		<table border="1" id="tbl">
			<caption>水果列表</caption>
			<tr>
				<th width="25%">名称</th>
				<th width="25%">单价</th>
				<th width="25%">数量</th>
				<th>操作</th>	
			</tr>
<%
		Object fruitListObj=session.getAttribute("fruitList");//session中返回的是Object类型
		if(fruitListObj==null||(((List<Fruit>)fruitListObj).size()<=0)){		
%>
				<tr>
					<th colspan="4">对不起，没有任何数据！</th>
				</tr>
<%
		}else{
			List<Fruit>fruitList=(List<Fruit>)fruitListObj;
			for(Fruit fruit:fruitList){
%>
		<tr>
			<td>
			<a href="detail_do.jsp?id=<%=fruit.getId()%>">
			<%=fruit.getName() %></a></td>
			<td><%=fruit.getPrice() %></td>
			<td><%=fruit.getCount() %></td>
			<td><input type="button" value="删除" class="btn" fid
			="<%=fruit.getId()%>" onclick="delFruit(<%=fruit.getId()%>)"			
			/></td><!--这里的fid是自己定义的一个属性 -->
		</tr>
<%
			}							
		}
%>
		</table>
<% 
	//从session中获取当前页码。如果获取不到，默认为第一页，没有点击4个按钮则返回为null
	Object currPageObj=session.getAttribute("currPage");
	int pageNum=0;
	if(currPageObj==null){
		pageNum=1;	
	}else{
		pageNum=(Integer)currPageObj;
	}
	Object pageCountObj=session.getAttribute("pageCount");//获取总页数
	int pageCount=0;
	if(pageCountObj==null){
		pageCount=0;
	}else{
		pageCount=(Integer)pageCountObj;
	}
%>
<div id="page_div">
	<!-- 将页码=1传给pre_index -->
	<input type="button" value="首页" class="btn" onclick="toPage(1)"  
	<%=(pageNum==1) ? "disabled" : ""  %>/>

	<!--将页码-1传给pre_index -->
	<input type="button" value="上一页" class="btn" onclick="toPage
	(<%=(pageNum-1) %>)" <%=(pageNum==1) ? "disabled" : ""  %>/>
	
	<!--将页码+1传给pre_index -->
	<input type="button" value="下一页" class="btn" onclick="toPage
	(<%=(pageNum+1) %>)" <%=(pageCount==pageNum )? "disabled" : "" %> />
	
	<!--将最大页码数也就是最后一页传给pre_index  -->
	<input type="button" value="尾页" class="btn" onclick="toPage
	(<%=pageCount %>)" <%=(pageCount==pageNum) ? "disabled" : "" %> />
	
	 </div>
	</div>
 </body>
</html>
