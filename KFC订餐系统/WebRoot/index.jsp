<%@page contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>开封菜订餐系统</title>
<style type="text/css">
	*{
		font-size:15px;
		color:#000000;
	}
	.btn{
		width:50px;
		height:20px;
		border:0;
	}
	
	html,body{
		height:100%;
		padding:0;
		margin:0;
		background-color: floralwhite;
	}
	#div0{
		height:120%;
		width:80%;
		margin-left:10%;
		padding:2px;
		border:1px solid gray;
		background:lemonchiffon;
	}
	#div1{
		height:15%;
		padding:5px;
		margin-bottom: 2px;
		border:1px solid gray;	
		background-image: url("imgs/banner.png");
		
	}
	
	#div2{
		width:19%;
		height:82%;
		float:left;
		border:1px solid gray;
		margin-right: 3px;
	}
	#div3{
		width:80.4%;
		height:82%;
		float:left;
		border:1px solid gray;	
	}
	iframe{
	height:100%;
	width:100%;
	border:0px;
	}
	
  </style>
  <script type="text/javascript">
  
  </script>
</head>
<body>
<div id="div0">
	<div id="div1" name="head">
			
	</div>		
	<div id="div2">
	<iframe src="left.html">
	</iframe>
	</div>
	
	
	<div id="div3">
	<iframe src="right.html">
	</iframe></div>
	
</div>
</body>
</html>