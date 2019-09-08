<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
<form action="login" method="post">
<table>
		     <caption>
		      论文管理系统
		     </caption>
		     <tbody>
		            <tr>
		               <td>
		               <label>账号:</label>
		               <input type="text" name="usercode" required="required">
		               </td>
		            </tr>
		            <tr>
		               <td>
		               <label>密码:</label>
		               <input type="password" name="userpassword" required="required">
		               </td>
		            </tr>
		            <tr>
		               <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="登录"> <input type="reset"> </td>
		            </tr>
		     </tbody>
      </table>
      </form>
</body>
</html>