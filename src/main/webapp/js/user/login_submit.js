$(document).ready(function(e) {
	var username;
	$("#USERNAME").blur(function(){//当焦点移开时触发事件
		username = $(this).val();
		console.log("username:"+username);
	});
	var password;
	$('#PASSWORD').blur(function(){
		password = $(this).val();
		console.log("password:"+password)
	});
	$('#login_submit').click(function login(){
		var url = "/ImgArt/user/login/"+username+"/"+password;
		console.log("url:"+url);
		$.get(url,function(rs){//rs:是请求返回的结果
			if(rs == "success"){//对请求的数据进行逻辑处理
				location.href="/ImgArt/index/main";
			}else{
				alert("用户名或密码不正确");
			}
		});
	});
});