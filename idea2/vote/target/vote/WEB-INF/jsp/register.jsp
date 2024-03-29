<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script src="js/kit.js"></script>
<!--[if IE]>
		<script src="js/ieFix.js"></script>
		<![endif]-->
<script type="text/javascript">
			var _gaq = _gaq || [];
			_gaq.push(['_setAccount', 'UA-30210234-1']);
			_gaq.push(['_trackPageview']);
			(function() {
				var ga = document.createElement('script');
				ga.type = 'text/javascript';
				ga.async = true;
				ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
				var s = document.getElementsByTagName('script')[0];
				s.parentNode.insertBefore(ga, s);
			})();

		</script>
<script src="js/dom.js"></script>
<script src="js/form.js"></script>
<link rel="stylesheet" href="css/css.css" />
<link rel="stylesheet" href="css/login.css" />
<link rel="stylesheet" href="css/validator.css" />
<!--validator-->
<script src="js/validator.js"></script>
<script src="js/autowired.validator.js"></script>
<style>
table td {
	font-size: 14px;
}

label {
	cursor: pointer;
	margin-right: 1em;
}
</style>
</head>
<body>
	<h1>欢迎进入注册页面</h1>
	<div id="regist-main">
		<form id="registForm" action="vote?src=addUser" method="post"
			onsubmit="alert('验证通过，可以提交！');">
			<ol>
				<li><label for="UserName">用户名： <span
						class="kitjs-validator" for="@UserName"
						rules="[{notNull:true, message:'用户名不能为空'}]"></span>
				</label> <span class="field-validation-valid" data-valmsg-for="UserName"
					data-valmsg-replace="true"></span> <input id="UserName"
					name="UserName" type="text" value=""></li>
				<li><label for="Email">电子邮件： <span
						class="kitjs-validator" for="@Email"
						rules="[{notNull:true, message:'电子邮件不能为空'},{isEmail:true,message:'电子邮件格式不正确'}]"></span>
				</label> <span class="field-validation-valid" data-valmsg-for="Email"
					data-valmsg-replace="true"></span> <input id="Email" name="Email"
					type="text" value=""></li>
				<li><label for="Password">密码： <span
						class="kitjs-validator" for="@Password"
						rules="[{notNull:true, message:'密码不能为空'},{minLength:'6',message:'密码长度最少为6位'}]"></span>
				</label> <span class="field-validation-valid" data-valmsg-for="Password"
					data-valmsg-replace="true"></span> <input id="Password"
					name="Password" type="password"></li>
				<li><label for="ConfirmPassword">重新输入密码： <span
						class="kitjs-validator" for="@ConfirmPassword"
						rules="[{notNull:true, message:'重新输入密码不能为空'},{equalWith:'@Password',message:'两次输入密码必须一致'},{minLength:'6',message:'密码长度最少为6位'}]"></span>
				</label> <span class="field-validation-valid"
					data-valmsg-for="ConfirmPassword" data-valmsg-replace="true"></span>
					<input id="ConfirmPassword" name="ConfirmPassword" type="password">
				</li>
				<li><label for="ConfirmPassword">请输入组织码：</label> <input
					id="gid" name="gid" type="text"></li>
			</ol>
			<div class="registError"></div>
			<input type="submit" value="注册" class="btn-submit">
		</form>
	</div>
</body>
</html>