<%@page import="com.gem.fruit.util.StringUtil"%>
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
				height:50%;
				margin-top:100px;
				background-color:menu;
				padding-top:50px;
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
			}
			#tbl tr{
				text-align:center;
				height:25px;
			}
			.btn{
				width:50px;
				height:20px;
				border:0;
				background-color:forestgreen;
				color:white;
			}
			.no_underline{
				text-decoration:none;
			}
			#page_div{
				border:0px solid red ;
				text-align:center;
				padding-top:4px;
				padding-bottom:4px;
			}
			input[class="btn"][disabled]{
				background-color: gray;
			}
		</style>
		<script type="text/javascript">
			function delFruit(fid){
				if(confirm('是否确认删除？')){
					window.location.href="del.html?fid="+fid;
				}
			}
			function toPage(pageNum){
				window.location.href="preIndex.html?currPage="+pageNum;
			}
		</script>
	</head>
	<body>
		<div id="div0">
			<div style="text-align:right;padding-right:30px;"><a class="no_underline" href="add.jsp">添加新水果</a></div>
			<div style="text-align:center;">
				<form action="preIndex.html" method="post">
					<input type="hidden" name="operate" value="search"/>
					请输入关键字：<input type="text" name="keyword" value="${keyword }"/>
					<input type="submit" value="查询" class="btn"/>
				</form>
			</div>
			<table border="1" id="tbl">
				<caption>水果列表</caption>
				<tr>
					<th width="25%">名称</th>
					<th width="25%">单价</th>
					<th width="25%">数量</th>
					<th>操作</th>
				</tr>
		<c:choose>
			<c:when test="${empty fruitList }">
				<tr>
					<th colspan="4">对不起，没有任何数据！</th>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${fruitList }" var="fruit">
					<tr>
						<td><a href="detail.html?id=${fruit.id }">${fruit.fname }</a></td>
						<td>${fruit.price }</td>
						<td>${fruit.count }</td>
						<td><input type="button" value="删除" class="btn" fid="${fruit.id }" onclick="delFruit(${fruit.id })"/></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
			</table>
			<c:set var="pageNum" value="${(not empty currPage) ? currPage : 1 }" scope="session"/>
			<c:set var="pageCount" value="${(not empty pageCount) ? pageCount : 0 }" scope="session"/>
			<div id="page_div">
				<input type="button" value="首页" class="btn" onclick="toPage(1)" ${ (pageNum le 1) ? "disabled" : "" }/>
				<input type="button" value="上一页" class="btn" onclick="toPage(${pageNum-1})" ${ (pageNum le 1) ? "disabled" : "" }/>
				<input type="button" value="下一页" class="btn" onclick="toPage(${pageNum+1})" ${(pageCount==pageNum) ? "disabled" : "" }/>
				<input type="button" value="尾页" class="btn" onclick="toPage(${pageCount})"  ${(pageCount==pageNum) ? "disabled" : "" } />
			</div>
		</div>
	</body>
</html>


<!-- 
现在，我需要做一件事情：
我需要让JSP分成两种角色：
1.数据展示
2.业务处理
 -->
