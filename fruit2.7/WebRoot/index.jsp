<%@page import="com.gem.fruit.util.StringUtil"%>
<%@page contentType="text/html; charset=utf-8"%>
<%@page import="java.util.List" %>
<%@page import="com.gem.fruit.dao.Impl.FruitDAOImpl"%>
<%@page import="com.gem.fruit.dao.FruitDAO"%>
<%@page import="com.gem.fruit.pojo.Fruit"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		function setColor(){
			var td=event.srcElement;
			if(td&&td.tagName=="TD"){
				var tr=td.parentElement;
				tr.style.backgroundColor="coral";
			}
		}
		function clearColor(){
			var td=event.srcElement;
			if(td&&td.tagName=="TD"){
				var tr=td.parentElement;
				tr.style.backgroundColor="";
			}
		}
		window.onload=function(){
			var tbl=document.getElementById("tbl");
			var rows=tbl.rows;
			for(var i=1;i<legth;i++){
				var tr=rows[i];
				tr.onmouseover=setColor;
				tr.onmouseout=clearColor;
			}
		}
	</script>
	</head>
<body>

	<div id="div0">
	<div style="text-align:right;padding-right:30px;">
	<a class="no_underline" href="add.jsp">添加新水果</a>
	</div>
	
	
	<div style="text-align:center;">
	
	<form action="pre_index.jsp" method="post">
	
	<input type="hidden" name="operate" value="search"/>
	
	请输入关键字:<input type="search" name="keyword" value=
	"${keyword}"/><!--从session中找到keyword,找不到则为null-->
	<input type="submit" style="background-color: gold;" value="查询" class="btn"/>
	</form>
	</div>
		<table border="1" id="tbl">
			<caption>水果列表</caption>
			<tr>
				<th width="25%">名称</th>
				<th width="25%">单价</th>
				<th width="25%">数量</th>
				<th>
				<input type="button" id="delAllBtn" value="批量删除" class="btn" style="width:70px;"/>
				</th>	
			</tr>
		<c:choose>
			<c:when test="${empty fruitList}">
				<tr>
					<th colspan="4">对不起没有任何数据!</th>
				</tr>
				</c:when>		
		<c:otherwise>
			<c:forEach items="${fruitList}" var="fruit">
			<tr>
				<td>
				<a href="detail_do.jsp?id=${fruit.id}">
				${fruit.name}</a></td>
				<td>${fruit.price}</td>
				<td>${fruit.count}</td>
				<td><input type="button" value="删除" class="btn" fid
				="${fruit.id} " onclick="delFruit(${fruit.id})"			
			/></td><!--这里的fid是自己定义的一个属性 -->
		   </tr>
		 </c:forEach>
	  </c:otherwise>
	</c:choose>
</table>
<c:set var="pageNum" value="${(not empty currPage)?currPage : 1}" scope="session"/>
<c:set var="pageCount" value="${(not empty pageCount)?pageCount : 0 }" scope="session"/>

<div id="page_div">
	<!-- 将页码=1传给pre_index,如果pageNum小于等于1 -->
	<input type="button" value="首页" class="btn" onclick="toPage(1)"  
	${(pageNum le 1)? "disabled" : "" }  />

	<!--将页码-1传给pre_index -->
	<input type="button" value="上一页" class="btn" onclick="toPage
	(${(pageNum-1)})" 	${(pageNum le 1)? "disabled" : "" }  />
	
	<!--将页码+1传给pre_index -->
	<input type="button" value="下一页" class="btn" onclick="toPage
	(${(pageNum+1)})" ${(pageCount==pageNum )? "disabled" : "" }/>
	
	<!--将最大页码数也就是最后一页传给pre_index  -->
	<input type="button" value="尾页" class="btn" onclick="toPage
	(${pageCount})" ${(pageCount==pageNum )? "disabled" : "" }/>
	
	 </div>
	</div>
 </body>
</html>
