<%-- Created by IntelliJ IDEA. User: apple Date: 2019/6/5 Time: 9:04 To change this template use File | Settings | File Templates. --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Title</title></head>
<body>
<table>
    <thead>
    <tr>
        <td>航空公司</td>
        <td>出发机场</td>
        <td>到达机场</td>
        <td>出发时间</td>
        <td>到达时间</td>
        <td>机型</td>
    </tr>
    </thead>
    <tbody><c:forEach items="${list}" var="a">
        <tr>
            <td>${a.company}</td>
            <td>${a.leaveAirport}</td>
            <td>${a.arriveAirport}</td>
            <td>${a.leaveTime}</td>
            <td>${a.arriveTime}</td>
            <td>${a.airplane}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>
<a href="">下一页</a>
</body>
</html>
