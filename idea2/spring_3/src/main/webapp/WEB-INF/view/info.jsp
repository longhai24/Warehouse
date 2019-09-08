<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<body>
	<table border="1" width="500">
		<tbody>
			<tr>
				<th>编号:</th>
				<td>${PERSON.pid}</td>
			</tr>
			<tr>
				<th>姓名:</th>
				<td>${PERSON.pname}</td>
			</tr>
			<tr>
				<th>性别:</th>
				<td>${PERSON.psex}</td>
			</tr>
			<tr>
				<th>生日:</th>
				<td><fmt:formatDate value="${PERSON.pdate}"
						pattern="yyyy年MM月dd日" /></td>
			</tr>
			<tr>
				<th>收货地址:</th>
				<td><c:forEach items="${PERSON.addresses }" var="temp">
						${temp.aname }&nbsp;&nbsp;
					</c:forEach></td>
			</tr>
		</tbody>
	</table>
</body>
</html>
