<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>

	<body>
		<h3>空气质量检测信息库</h3>
		<p> 按区域查询:
			<select name="ojo">
				<c:forEach items="${listd}" var="k">
					<option value="${k.id}">${k.name}</option>
				</c:forEach>
			</select>
			<a name="cvbnm"> 查询</a>
			<a href="kl?usr=addjsp">添加空气质量库</a>
		</p>
		<table>
			<thead>
				<tr>
					<td>序号</td>
					<td>区域</td>
					<td>检测时间</td>
					<td>PM10数据</td>
					<td>pm2.5数据</td>
					<td>监测站</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="l">
					<tr>
						<td><a href="kl?usr=skipxiu&id=${l.id}">${l.id}</a></td> 
						<td>${l.district_id.name}</td>
						<td>${l.monitor_time}</td>
						<td>${l.pm10}</td>
						<td>${l.pm25}</td>
						<td>${l.monitoring_station}</td>
					</tr>
				</c:forEach>
			</tbody>
			<tr>
				<td>
					<a>首页</a>
				</td>
				<td>
					<a href="kl?usr=likeCaoPage&cao=prev">上一页</a>
				</td>
				<td>
					<a href="kl?usr=likeCaoPage&cao=next">下一页</a>
				</td>
				<td>
					<a>尾页</a>
				</td>
			</tr>
		</table>
	</body>
	<script src="js/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		$('[name="cvbnm"]').click(function() {
			var id = $(this).parents("p").find($('[name="ojo"]')).val();
			alert(id)
			$.ajax({
				url: "kl?usr=ddfd",
				data: {'id':id},
				type: "post",
				dataType: "text",
				success: function(result) {
					if("ok" == result){
						location.href="kl?usr=like";
					}
				}
			});
		})
	</script>

</html>