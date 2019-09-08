<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1px solid">
<thead>
</thead>
<tbody>
<tr>
<td>编号</td>
<td>${sum.tender_id }</td>
</tr>

<tr>
<td>工程名</td>
<td>${sum.project_name }</td>
</tr>

<tr>
<td>投标单位</td>
<td>
<c:forEach items="${sum.blist }" var="s">
${s.company }
</c:forEach>

</td>
</tr>
</tbody>
</table>
</body>
</html>