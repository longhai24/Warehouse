<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<style type="text/css">
.border{
	border-radius: 5px;
	margin: 10px 0px;
}
	.bottom{
		border-radius: 10px;

	}
</style>
</head>
<body>
<form action="login" method="post">
<table style="margin: 0px auto;">
		     <caption>
		      论文管理系统
		     </caption>
		     <tbody>
		            <tr>
		               <td>
		               <label>账号:</label>
		               <input type="text" name="usercode" required="required" class="border">
		               </td>
		            </tr>
		            <tr>
		               <td>
		               <label>密码:</label>
		               <input type="password" name="userpassword" required="required" class="border">
		               </td>
		            </tr>
		            <tr>
		               <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="登录" class="bottom">  <input type="reset" class="bottom"> </td>
		            </tr>
		     </tbody>
      </table>
      </form>
</body>
</html>