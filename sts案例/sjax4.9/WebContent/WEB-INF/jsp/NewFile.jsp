<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="/sjax4.9/JS/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
		$("select").change(function() {
			$("#sel1").children().remove();
			//获取下拉框的id
			var id = $(this).val();
			var xhr = null;
			if (window.XMLHttpRequest) {
				xhr = new XMLHttpRequest();
				xhr.open("post","Tes tAction");
				xhr.setRequestHeader("content-Type","application/x-www-form-urlencoded;");
				xhr.send("method=sel&did="+id);
				xhr.onreadystatechange = function() {
					if (xhr.readyState ==4) {
						if (xhr.status ==200) {
							var txt = xhr.responseText;
							var json = eval('('+txt+')');
							for ( var i in json) {
								var op  =$("<option>"+json[i].sname+"</option>");
								$("#sel1").append(op);
							}
						}
					}
				}
			}
		})
	})
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<select>
	<c:forEach items="${list }" var="a">
	<option value="${a.id }">${a.name }</option>
	</c:forEach>
	</select>
	<select id ="sel1">
	
	</select>
</body>
</html>