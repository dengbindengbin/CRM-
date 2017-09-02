<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="no-js">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>login</title>
<link rel="stylesheet" type="text/css" href="/static/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="/static/css/demos.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="/static/css/component.css" />
<!--[if IE]>
<script src="js/html5.js"></script>
<![endif]-->
<script type="text/javascript" src="/static/plugins/easyui/jquery.min.js"></script> 
<script type="text/javascript">
	function submitForm(){
		if($("[name='username']").val()&&$("[name='password']").val()){
			$("form").submit();
		}
	}
	
	function refer(){
		if($("[name='username']").val()&&$("[name='password']").val()){
		$("form").submit();
		}
	}
	
	//按回车键直接提交表单
	$(document).keyup(function(event){
		//判断是否是回车键
		if(event.keyCode==13){
			//提交表单
			submitForm();
		}
	});
	
	
	$(function(){
		//判断是否有错误信息
		var msg = '${errorMsg}';
		if(msg){
			alert(msg);
		}
	})
	
</script>
</head>
<body>
		<div class="container demo-1">
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<div class="logo_box">
						<h3>欢迎你</h3>
						<form action="/login.do" method="post">
							<div class="input_outer">
								<span class="u_user"></span>
								<input name="username" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户">
							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input name="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码">
							</div>
							<div class="mb2"><a class="act-but submit" href="javascript:;" style="color: #FFFFFF" onclick="refer()">登录</a></div>
						</form>
					</div>
				</div>
			</div>
		</div><!-- /container -->
		<script src="/static/js/TweenLite.min.js"></script>
		<script src="/static/js/EasePack.min.js"></script>
		<script src="/static/js/rAF.js"></script>
		<script src="/static/js/demo-1.js"></script>
		<script type="text/javascript" src="/static/plugins/layer/layer.js"></script>

		<div style="text-align:center;">
</div>
	</body>
</html>