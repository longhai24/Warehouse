<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="BankAction?method=login" method="post">
	<table>
	<tr>
	<td>卡号：</td>
	<td><input type="text" name=cardno> </td>
	</tr>
	<tr>
	<td>密码：</td>
	<td><input type="text" name=password> </td>
	</tr>
		<tr>
	<td><input type="submit" value="提交"> </td>
	</tr>
	</table>
</form>
</body>
</html>