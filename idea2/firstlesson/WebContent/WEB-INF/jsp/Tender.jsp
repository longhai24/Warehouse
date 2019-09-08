<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script src="/static/js/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$(function(){
		
	})
</script>
<body>
	<table border="" cellspacing="" cellpadding="">
		<thead>
			<tr style="background-color: red;">
				<th>序号</th>
				<th>工程名</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${tenderlist}" var="l">
				<tr>
					<td>${l.tender_id}</td>
					<td>${l.project_name}</td>
					<td><a href="tender?usr=select&id=${l.tender_id}">详情</a><a href="tender?usr=delete&id=${l.tender_id}">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>