<%@ page contentType="text/html;charset=utf-8"%>

<html>
	<head>
	</head>
	<body>
		<form action="user.do" method="post">
			<input type="hidden" name="operate" value="login">
			账号：<input type="text" name="loginId" value="u01"/><br/>
			密码：<input type="password" name="pwd" value="ok"/><br/>
			<input type="submit" value="登录"/>
			<input type="reset" value="重置"/>
		</form>
	</body>
</html>