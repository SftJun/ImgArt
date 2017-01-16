<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!--移动设备优先-->
	<title>图片上传</title>
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
		<h1>图片上传</h1>
		<form action="upload" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="location">拍摄地点</label>
				<input type="text" class="form-control" id="location" name="location" placeholder="请输入拍摄地点">
			</div>
			<div class="form-group">
				<label for="shortInfo">图片简介</label>
				<input type="text" class="form-control" id="shortInfo" name="shortInfo" placeholder="请输入图片简介">
			</div>
			<div class="form-group">
				<label for="files">图片选择</label>
				<input type="file" id="files" name="files" multiple="multiple"/>
			</div>
			<button type="submit" class="btn btn-primary start">提交</button>
		</form>
	</div>
</body>
</html>