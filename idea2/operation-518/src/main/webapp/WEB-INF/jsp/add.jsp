<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>添加空气质量</h3>
	<form action="kl?usr=addair" method="post">
		<p> 按区域查询:<select name="id"> 
	<c:forEach items="${listd}" var="k">
		<option value="${k.id}">${k.name}</option>
	</c:forEach>
</select></p>

	<p>检测日期: <input type="text" name="time"/></p>
	<p>PM10: <input type="text" name="pm10"/></p>
	<p>PM2.5: <input type="text" name="pm25"/></p>
	<p>检测站: <input type="text" name="zhan"/></p>
	<input type="submit" value="保存">
	
	<input type="reset" value="重置">
	</form>
</body>
</html>