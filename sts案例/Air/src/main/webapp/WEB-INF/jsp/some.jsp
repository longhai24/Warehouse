<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<form action="AirAction?method=Update" method="post">
			<tr>
				<td>监测区域</td>
				<td><select name=district>
						<option value="1">丰台区</option>
						<option value="2">西城区</option>
						<option value="3">北城区</option>
				</select></td>
			</tr>
			<tr>
				<td>监测日期</td>
				<td><input type="text" name=date value="${show.monitor_time }"></td>
			</tr>
			<tr>
				<td>PM10值</td>
				<td><input type="text" name=pm10 value="${show.pm10}"></td>
			</tr>
			<tr>
				<td>PM2.5值</td>
				<td><input type="text" name=pm25 value="${show.pm2_5}"></td>
			</tr>
			<tr>
				<td>监测站</td>
				<td><input type="text" name=address value="${show.monitoring_station}"></td>
			</tr>
			<tr>
				<td><input type="submit" value="修改"></td>
				<td><input type="button" value="删除" id = del></td>
			</tr>
		</form>
	</table>
</body>
<script type="text/javascript" src="jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$("#del").click(function () {
	$.ajax({
		url:"AirAction",
		data:{method:"removeAir"},
		type:"post",
		success:function(data){
			window.location.href="http://localhost:8080/Air/AirAction?method=tologin";
		}
	})
})

</script>
</html>