<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="/Test4.3/JS/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".a1").click(function () {
			var id = $(this).parent().parent().attr("id");
			window.location.href="TenderAction?method=tofind&id="+id;
			return false;
		})
		$(".a2").click(function() {
			var id = $(this).parent().parent().attr("id");
			window.location.href="TenderAction?method=todel&id="+id;
			return false;
		})
	})
</script>
</head>

<body>
<table border="1px solid">
	<thead>
	<tr>
	<th>编号</th>
	<th>工程名</th>
	<th>操作</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${list }" var="a">
	<tr id="${a.tender_id}">
	<td>${a.tender_id }</td>
	<td>${a.project_name }</td>
	<td> <a href="aa" class="a1">详情</a> <a href="aa" class="a2">删除</a>  </td>
	</tr>
	</c:forEach>
	
	
	</tbody>
</table>
</body>
</html>