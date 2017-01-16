<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!--移动设备优先-->
		<title>ImgArt</title>
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
		<script type="text/javascript" src="/ImgArt/js/main/request.js"></script>
		<body>
			<div class="container">
			<div id="myCarousel" class="carousel slide">
				<!-- 轮播（Carousel）指标 -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
				</ol>
				<!-- 轮播（Carousel）项目 -->
				<div class="carousel-inner">
				</div>
				<!-- 轮播（Carousel）导航 -->
				<a class="carousel-control left" href="#myCarousel" data-slide="prev"><img src="/ImgArt/img/left.png"/></a>
				<a class="carousel-control right" href="#myCarousel" data-slide="next"><img src="/ImgArt/img/right.png"/></a>
			</div> 
			</div>
		</body>
</html>