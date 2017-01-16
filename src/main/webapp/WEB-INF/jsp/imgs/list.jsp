<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!--移动设备优先-->
		<title>图片显示</title>
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
		
		<script type="text/javascript" src="/ImgArt/js/img/list.js"></script>
	<body>
		<div class="container">
			<ul class="pagination">
			    <li><a href="#">&laquo;</a></li>
			    <li class="active"><a href="#">1</a></li>
			    <li class="disabled"><a href="#">2</a></li>
			    <li><a href="#">3</a></li>
			    <li><a href="#">4</a></li>
			    <li><a href="#">5</a></li>
			    <li><a href="#">&raquo;</a></li>
			</ul>
			<h1>图片显示</h1>
			<input type="button" id="listimg" name="listimg" value="List Img" />
			<div id="imgs">
			</div>
		</div>
	</body>
</html>