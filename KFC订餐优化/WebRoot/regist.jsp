<%@page contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>用户注册</title>
<style>
	*{
		font-size:15px;
		color:coral;
	}
	html,body{
		width:100%;
		height:100%
	}
	#div0{
		height:80%;
		width:60%;
		margin-left:20%;
		margin-top:50px;
		border:1px solid gray;
		background-color: blanchedalmond;
	}
	#registDiv{
		width:60%;
		height:80%;
		background-color: beige;
		margin-top:50px;
		margin-bottom: 15%;
		margin-left: 20%;
		border:1px solid gray;
		float:left;
	}
	.tbl{
		margin-left:70px;
	}
</style>
<script type="text/javascript">
	var myvalidate=function(frm){
		var frm=document.frm;
		var nickName=frm.nickName;
		var pwd=frm.pwd.value;
		var pwd2=frm.pwd2.value;
		if(nickName==""){
			alert("昵称不能为空!");
			return false;
		}
		if(pwd==""){
			alert("密码不能为空!");
			return false;
		}
		if(pwd2!=pwd){
			alert("两次密码不一致");
			return false;
		}
		var genderArr=frm.gender;
		if(!genderArr[0].checked&&!genderArr[1].checked){
			alert("性别不能为空!");
			return false;
		}
	}
		
		
		var provinceArr=["北京","江苏","江西","安徽"];
		var bjCities=["怀柔","丰台","朝阳"];
		var jsCities=["南京","苏州","无锡","常州","扬州","泰州","徐州"];
		var jxCities=["南昌","吉安","九江","赣州","鹰潭","上饶"];
		var ahCities = ["合肥","巢湖","芜湖","铜陵","亳州"];
		
		var cities=[bjCities,jsCities,jxCities,ahCities];
		
		window.onload=loadProvince;
		function $(id){
			return document.getElementById(id);
		}
		function loadProvince(){
			var sltProvince=$("province");
			for(var i=0;i<provinceArr.length;i++){
				var provinceStr=provinceArr[i];
				var option=new Option(provinceStr,i+1);
				sltProvince.options.add(option,i+1);
			}
			sltProvince.onchange=selectCity;
		}
		function selectCity(){
			var sltCity=$("city");
			sltCity.options.length=1;
			var provinceValue=event.srcElement.value;//value是位置
			var cityArr=cities[provinceValue-1];//provinceValue的位置-1就是下标
			for(var i=0;i<cityArr.length;i++){
				var option=new Option(cityArr[i],i+1);
				sltCity.options.add(option,i+1);
			}
			
		}

</script>
</head>

<body>
	<div id="div0">
	 <div id="registDiv">
	 	<form action="login.do?operate=registDo" method="post" name="frm" onsubmit="return myvalidate();">
	 		<table class="tbl" width="100%"  height="100%" border="0" cellspacing="0" cellpadding="2">
	 		<tr>
	 			<th>账号:</th>
	 			<td><input type="text" name="loginId"/></td>
	 		</tr>
	 		<tr>
	 			<th>昵称:</th>
	 			<td><input type="text" name="nickName"/></td>
	 		</tr>
	 		<tr>
	 			<th>密码:</th>
	 			<td><input type="password" name="pwd"/></td>
	 		</tr>
	 		<tr>
	 			<th>请再次输入密码:</th>
	 			<td><input type="password" name="pwd2"/></td>
	 		</tr>
	 		
	 		<tr>
	 			<th>真实姓名:</th>
	 			<td><input type="text" name="realName"/></td>
	 		</tr>
	 		<tr>
			<th>性别:</th>
				<td>
				<input type="radio" name="gender" value="male"/>男
				<input type="radio" name="gender" value="female"/>女
				</td>
			</tr>
			<tr>
				<th>地址:</th>
				<td>
				<select id="province" name="province">
					<option value="-1">--省份--</option>
				</select>
				<select id="city" name="city">
					<option value="-1">--城市--</option>
				</td>				
			</tr>
			<tr>
			<th>联系电话:</th>
				<td>
				<input type="text" name="tel"/>		
				</td>
			</tr>
					<th colspan="2">
						<input type="submit"  value="注册"/>&nbsp;&nbsp;&nbsp;&nbsp;						
				<a href="login.jsp"><input type="button" value="返回"/></a>	
				</th>
				</tr>
	 		</table>
	 	</form>	 
	 </div>	
	</div>
</body>
</html>
