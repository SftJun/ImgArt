<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE HTML>
<html>
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!--移动设备优先-->
	<title>Register</title>
	<!-- Bootstrap -->
	<link href="/ImgArt/css/bootstrap.min.css" rel="stylesheet">
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="/ImgArt/js/jquery-3.1.0.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="/ImgArt/js/bootstrap.min.js"></script>
	<!--如果IE版本小于9，则加载下面的文件-->
		<!--[if lt IE 9]>
			<script src="/ImgArt/js/html5shiv.min.js"></script>
			<script src="/ImgArt/js/respond.min.js"></script>
		<![endif]-->
	</head>
	<body>
		<div class="container">
			<form action="register" method="post" >
				<div class="form-group">
					<label for="USERNAME">用户名</label>
					<input type="text" class="form-control" id="USERNAME" name="USERNAME" placeholder="请输入用户名">
				</div>
				<div class="form-group">
					<label for="PASSWORD">密码</label>
					<input type="text" class="form-control" id="PASSWORD" name="PASSWORD" placeholder="请输入密码">
				</div>
				<div class="form-group">
					<label for="AGE">年龄</label>
					<input type="text" class="form-control" id="AGE" name="AGE" placeholder="请输入年龄">
				</div>
				<div class="form-group">
					<label for="GENDER">性别</label>
					<input type="text" class="form-control" id="GENDER" name="GENDER" placeholder="请输入性别">
				</div>
				<div class="form-group">
					<label for="TEL">电话</label>
					<input type="text" class="form-control" id="TEL" name="TEL" placeholder="请输入电话号码">
				</div>
				<button type="submit" class="btn btn-default">提交</button>
			</form>
		</div>
	</body>
</html>