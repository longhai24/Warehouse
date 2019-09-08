<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="/firstlesson/static/js/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$(function(){
		//年龄的升序事件
		$("#up").click(function(){
			window.location.href="student?usr=sort&sort=age";
		})
		//id的降序序事件
		$("#stuid").click(function(){
			window.location.href="student?usr=sort&sort=id";
		})
	})
</script>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th id="stuid">学号</th>
				<th>姓名</th>
				<th id="up">年龄</th>
				<th>入学年龄</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${studentlist}" var="l">
				<tr>
					<td>${l.id}</td>
					<td>${l.name}</td>
					<td>${l.age}</td>
					<td>${l.time}</td>
					<td>删除</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>