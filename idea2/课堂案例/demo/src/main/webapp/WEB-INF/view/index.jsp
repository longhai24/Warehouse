<%--
  Created by IntelliJ IDEA.
  User: 25191
  Date: 2019/6/5
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <c:forEach items="${list}" var="l">
        <tr>
            <td>
                    ${l.id}
            </td>
            <td>
                    ${l.flightId}
            </td>
            <td>
                    ${l.company}
            </td>
            <td>
                    ${l.leaveAirport}
            </td>
            <td>
                    ${l.arriveAirport}
            </td>
            <td>
                    ${l.leaveTime}
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
