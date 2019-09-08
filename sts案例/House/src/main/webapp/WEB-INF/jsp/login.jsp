<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<LINK rel=stylesheet type=text/css href="css/style.css">
</head>
<body>
	<DIV id=header class=wrap>
		<DIV id=logo>
			<IMG src="images/logo.gif">
		</DIV>
	</DIV>
	<DIV id=regLogin class=wrap>
		<DIV class=dialog>
			<DIV class=box>
				<H4>用户登录</H4>
				<FORM id=user method=post name=user action=HouseAction?method=login>
					<DIV class=infos>
						<TABLE class=field>
							<TBODY>
								<TR>
									<TD colSpan=2></TD>
								</TR>
								<TR>
									<TD class=field>用 户 名：</TD>
									<TD>
										<!-- <input type="text" class="text" name="name" /> --> <INPUT
										id=user_name class=text type=text name=name>
									</TD>
								</TR>
								<TR>
									<TD class=field>密 码：</TD>
									<TD>
										<!-- <input type="password" class="text" name="password" /> -->
										<INPUT id=user_password class=text type=password name=password>
									</TD>
								</TR>
								<!--
						<tr>
							<td class="field">验 证 码：</td>
							<td><input type="text" class="text verycode" name="veryCode" /></td>
						</tr>
						-->
							</TBODY>
						</TABLE>
						<DIV class=buttons>
							<INPUT class="login" value=登陆 type="submit"> <INPUT
								 value=注册 type=button id=register>
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
	$("#register").click(function() {
		window.location.href="HouseAction?method=register";
	})
	
</script>
</html>