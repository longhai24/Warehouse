<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="/ajax4.4/JS/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("a").click(function() {
			var tr = $("<tr>");
			var th = $(this);
			var id = $(this).parent().parent().attr("id");
			var td = $("<td colspan='3' >正在加载中</td>");
			tr.append(td);
			$("#"+id).after(tr);
			var xhr = null;
			if (window.XMLHttpRequest) {
				xhr = new XMLHttpRequest();
				xhr.open("post","StaffAction");
				xhr.setRequestHeader("content-Type","application/x-www-form-urlencoded;");
				xhr.send("method=sel&id="+id);
				xhr.onreadystatechange = function() {
					if (xhr.readyState==4) {
						if (xhr.status == 200) {
							var txt = xhr.responseText;
							var json = eval('('+txt+')');
							var word = "编号："+json.id+" 姓名："+json.name+" 地址："+json.site+" email："+json.email;
							th.parents("tr").next().find("td").html(word);
						}
						else if(xhr.status ==404){
							alert("页面错误")
						}
					}
				}
				
				
			}
			
			return false;
		})
	})
</script>
</head>
<body>
	<table border="1px solid">
		<thead>
			<tr>
				<td>编号</td>
				<td>姓名</td>
				<td>操作</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="a">
				<tr id="${a.id }">
					<td>${a.id }</td>
					<td>${a.name }</td>
					<td><a href="a">查看详情</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>