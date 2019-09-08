<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<LINK rel=stylesheet type=text/css href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<DIV id=header class=wrap>
		<DIV id=logo>
			<IMG src="images/logo.gif">
		</DIV>
	</DIV>
	<DIV id=regLogin class=wrap>
		<DIV class=dialog>
			<DL class=clearfix>
				<DT>新用户注册</DT>
				<DD class=past>填写个人信息</DD>
			</DL>
			<DIV class=box>
				<FORM action=HouseAction?method=addUser method="post">
					<DIV class=infos>
						<TABLE class=field>
							<TBODY>
								<TR>
									<TD class=field>用 户 名：</TD>
									<TD><INPUT class=text type=text name=name></TD>
								</TR>
								<TR>
									<TD class=field>密 码：</TD>
									<TD><INPUT class=text type=password name=password id=pwd></TD>
								</TR>
								<TR>
									<TD class=field>确认密码：</TD>
									<TD><INPUT class=text type=password name=repassword id=cpwd>
									</TD>
								</TR>
								<TR>
									<TD class=field>电 话：</TD>
									<TD><INPUT class=text type=text name=telephone ></TD>
								</TR>
								<TR>
									<TD class=field>用户姓名：</TD>
									<TD><INPUT class=text type=text name=username></TD>
								</TR>
							</TBODY>
						</TABLE>
						<DIV class=buttons>
							<INPUT id=cub value=立即注册 type="button">
						</DIV>
					</DIV>
				</FORM>
			</DIV>
		</DIV>
	</DIV>
	<DIV id=footer class=wrap>
		<DL>
			<DT>青鸟租房 © 2010 北大青鸟 京ICP证1000001号</DT>
			<DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD>
		</DL>
	</DIV>
</body>
<script type="text/javascript" src="jquery-3.3.1.min.js"></script>
<script type="text/javascript">
alert("123")
	$("#cub").submit().click(function() {
	var cpwd = $("#cpwd").val();		
	var pwd = $("#pwd").val();
	if (pwd != cpwd) {
		alert("两次密码输入不一致")
	}else {
		$("form").submit();
	}
	})
</script>
</html>