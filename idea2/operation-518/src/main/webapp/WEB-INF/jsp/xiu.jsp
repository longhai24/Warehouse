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
		<h3>添加空气质量</h3>
		<form action="kl?usr=uio" method="post">
			<p> 按区域查询:
				<select name="id">
					<c:forEach items="${listd}" var="k">
						<option value="${k.id}">${k.name}</option>
					</c:forEach>
				</select>
			</p>
			<input type="hidden" value="${a.id}" name="aid">
			<p>检测日期: <input type="text" name="time" value="${a.monitor_time}" /></p>
			<p>PM10: <input type="text" name="pm10" value="${a.pm10}" /></p>
			<p>PM2.5: <input type="text" name="pm25" value="${a.pm25}" /></p>
			<p>检测站: <input type="text" name="zhan" value="${a.monitoring_station}" /></p>
			<input type="submit" value="保存">
			<a href="kl?usr=dad&id=${a.id}">刪除</a>
			<input type="reset" value="重置">
		</form>
	</body>
	<script src="js/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		$('[name="id"]').val(${a.district_id.id});
	</script>

</html>