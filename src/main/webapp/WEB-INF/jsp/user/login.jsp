<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!--移动设备优先-->
	<title>Login</title>
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
	<script type="text/javascript" src="/ImgArt/js/user/login_submit.js"></script>
	</head>
	<body>
		<div class="container">
			<form action="login" method="post" >
				<div class="form-group">
					<label for="USERNAME">用户名</label>
					<input type="text" class="form-control" id="USERNAME" name="USERNAME" required="required" placeholder="请输入用户名">
				</div>
				<div class="form-group">
					<label for="PASSWORD">密码</label>
					<input type="password" class="form-control" id="PASSWORD" name="PASSWORD" required="required"　placeholder="请输入密码">
				</div>
				<button id="login_submit" type="button" class="btn btn-primary start">提交</button>
			</form>
		</div>
	</body>
</html>