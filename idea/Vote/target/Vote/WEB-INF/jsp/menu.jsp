<%-- Created by IntelliJ IDEA. User: apple Date: 2019/5/31 Time: 9:03 To change this template use File | Settings | File Templates. --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Title</title></head>
<body><h1>天星公司投票</h1>
<form action="VoteSubAction?method=BeganVote" method="post">
    <table>
        <tbody>
        <tr>
            <td>投票标题：${li.votetitle  }</td>
        </tr>
        <tr>
            <td>投票简介：${li.voteparticulars  }</td>
        </tr>
        <tr>
            <td>创建时间：${li.votedate  }</td>
        </tr>
        <tr>
            <td><input type="checkbox" name="c1" value="voteoption1poll" >${li.voteoption1  }</td>
        </tr>
        <tr>
            <td><input type="checkbox" name="c2" value="voteoption2poll" >${li.voteoption2  }</td>
        </tr>
        <tr>
            <td><input name="c3" type="checkbox" value="voteoption3poll">${li.voteoption3  }</td>
        </tr>
        <tr>
            <td><input name="c4" type="checkbox" value="voteoption4poll" >${li.voteoption4  }</td>
        </tr>
        <tr>
            <td><input class="in1" type="submit" value="投票"></td>
        </tr>
        </tbody>
    </table>
</form>
</body>
<script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
<script type="text/javascript">

</script>
</html>
