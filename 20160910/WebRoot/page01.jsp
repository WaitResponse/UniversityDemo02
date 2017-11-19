<%@page contentType="text/html;charset=utf-8"%>	<!-- page指令  ： page声明 -->

<!-- 视图展示 -->
<html>
	<head></head>
	<body>
		<form action="page02.jsp" method="post">
			用户名：<input type="text" name="uname"/><br/>
			爱好：<input type="checkbox" name="hobby" value="game1"/>英雄联盟
			<input type="checkbox" name="hobby" value="game2"/>地下城与勇士
			<input type="checkbox" name="hobby" value="game3"/>炉石传说<br/>
			<input type="submit" value="提交"/>
		</form>
	</body>
</html>