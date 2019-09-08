<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="" cellspacing="" cellpadding="">
		<c:forEach items="${bidlist}" var="l">
			<tr>
				<td>编号</td>
				<td>${l.ten.tender_id}</td>
			</tr>
			<tr>
				<td>工程名</td>
				<td>${l.ten.project_name}</td>
			</tr>
			<tr>
				<td>投标单位</td>
				<td>${l.company}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>