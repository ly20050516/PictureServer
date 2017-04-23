<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图片管理中央仓库</title>
<style>
#head {
	color: #FFFFFF;
	background-color: #FFFFFF;
	width: 100%;
	height: 20%;
	font-size: 40px;
	text-align: center;
}

#head_left {
	color: #FFFFFF;
	background-color: #668888;
	width: 25%;
	height: 100%;
	font-size: 40px;
	text-align: center;
	float: left;
}

#head_right {
	color: #FFFFFF;
	background-color: #668888;
	width: 25%;
	height: 100%;
	font-size: 40px;
	text-align: center;
	float: right;
}

#head_center {
	display: table-cell;
	margin-right: 0.1%;
	margin-left: 0.1%;
	color: #FFFFFF;
	background-color: #668899;
	width: 49.8%;
	height: 100%;
	font-size: 40px;
	text-align: center;
	vertical-align: middle;
	float: left;
}

#login {
	color: #FFFFFF;
	background-color: #FFFFFF;
	width: 100%;
	height: 69%;
	margin-top: 0.1%;
	font-size: 40px;
	text-align: center;
}

#login_left {
	color: #FFFFFF;
	background-color: #7733FF;
	width: 59.9%;
	height: 100%;
	margin-top: 1px;
	margin-right: 0.1%;
	font-size: 40px;
	text-align: center;
	float: left;
}

#login_right {
	float: left;
	color: #FFFFFF;
	background-color: #7799CC;
	width: 40%;
	height: 100%;
	margin-top: 1px;
	font-size: 40px;
	text-align: center;
}

#bottom {
	color: #FFFFFF;
	background-color: #88FF11;
	width: 100%;
	height: 15%;
	margin-top: 0.9% font-size:40px;
	text-align: center;
}
</style>
</head>

<body>

	<div id="head">
		<div id="head_left"></div>
		<div id="head_center">图片管理中央仓库</div>
		<div id="head_right"></div>
	</div>

	<div id="login">
		<div id="login_left">
			登陆
			<form action="/login" method="post" accept-charset="utf-8">
				用户名：<input type="text" name="UserName"><br/>
				密 码：<input type="password" name="password"><br/> 
					<input type="submit" value="Submit">
			</form>
		</div>
		<div id="login_right">登陆</div>
	</div>


	<div id="bottom">版本</div>
</body>
</html>