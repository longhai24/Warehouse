<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="/Test/JS/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
		$("table thead tr th").eq(2).click(function() {
			window.location.href="StuAction?method=Fsort&tname=age";
		})
		$("table thead tr th").eq(0).click(function() {
			window.location.href="StuAction?method=Nsort&tname=id";
		})
	})
</script>
<title>Insert title here</title>
</head>
<body>
<table border="1px solid">
<thead>
<tr>
<th>学号</th>
<th>姓名</th>
<th>年龄</th>
<th>入学时间</th>
<th>操作</th>
</tr>
</thead>
<tbody>
<c:forEach items="${LIST }" var="a">
	<tr>
	<td>${a.stuId }</td>
	<td>${a.stuName }</td>
	<td>${a.stuAge }</td>
	<td><fmt:formatDate value="${a.stuDate }" pattern="yyyy年-MM月-dd日"/> </td>
	<td></td>
	</tr>
 </c:forEach>
</tbody>
</table>
</body>
</html>