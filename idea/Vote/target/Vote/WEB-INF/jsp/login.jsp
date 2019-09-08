<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2019/5/28
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>天星公司投票网</h1>
<form action="VoteSubAction?method=login" method="post">
<table>
    <tr>
        <td>请输入用户名：</td>
        <td><input type="text" placeholder="请输入用户名" name="name"></td>
    </tr>
    <tr>
        <td>请输入密码：</td>
        <td><input type="password" placeholder="请输入密码" name="pwd"></td>
    </tr>
    <tr>
        <td><input type="submit" value="登录"></td>
        <td><a href="VoteSubAction?method=toregister">立即注册</a></td>
    </tr>
</table>
</form>
</body>
</html>
