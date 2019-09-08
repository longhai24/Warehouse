<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/style.css" rel='stylesheet' type='text/css' />
</head>
<body>
	<!-----start-main---->
	<div class="main">
		<div class="login-form">
			<h1>用户 登陆</h1>
			<div class="head">
				<img src="images/user.png" alt="" />
			</div>
			<form method="post" action="vote?src=dllogin">
				<input type="text" class="text" value="李棋" name="name"
					onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = 'USERNAME';}">
				<input type="password" value="123456" name="pwd" onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = 'Password';}">
				<div class="submit">
					<input type="submit" value="LOGIN">
				</div>
				<p>
					<a href="vote?src=skip-regs">Forgot Password ?</a>
				</p>
			</form>
		</div>
		<!--//End-login-form-->
		<!-----start-copyright---->
		<div class="copy-right">
			<p class="text-center mb-3 tm-footer-text">
				天星科技 &copy; 2019 <a href="" target="_blank" title="">李棋</a>
			</p>
		</div>
		<!-----//end-copyright---->
	</div>
	<!-----//end-main---->

	<div style="display: none">
		<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540'
			language='JavaScript' charset='UTF-8'></script>
	</div>
</body>

</html>