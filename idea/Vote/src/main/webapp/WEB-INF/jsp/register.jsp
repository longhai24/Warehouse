<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2019/5/28
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="VoteSubAction?method=addUser" method="post">
    <table>
        <tr>
            <td>请输入用户名：</td>
            <td><input type="text" placeholder="请输入你的姓名" name="uname"></td>
        </tr>
        <tr>
            <td>请输入你的密码：</td>
            <td><input type="password" name="upwd"></td>
        </tr>
        <tr>
            <td>请再输入一次密码:</td>
            <td><input type="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="立即注册"></td>
        </tr>
    </table>
</form>
</body>
</html>
