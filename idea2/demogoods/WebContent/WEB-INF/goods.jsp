<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h3>商品信息管理</h3>
		<table>
			<thead>
				<tr>
					<td>商品名称</td>
					<td>商品分类</td>
					<td>商品型号</td>
					<td>商品单价</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody id="td">
				<c:forEach items="${goodslist}" var="l">
					<tr>
						<td>${l.goodsName}
							<input type="hidden" value="${l.goodsid}">
						</td>
						<td>${l.glzz.goodsClassName}</td>
						<td>${l.goodsType}</td>
						<td>${l.goodsPrice}</td>
						<td>
							<a class="c">删除</a>
							<a class="x">修改</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
<script type="text/javascript" src="../static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(".c").click(function() {
		var id = $(this).parents("tr").find("td:eq(0)").find("input").val();
		$.ajax({
			url:"",
			data:"",
			dataType:"",
			type:"",
			success:
		})
	})
</script>
</html>