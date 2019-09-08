<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script src="/firstlesson/static/js/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$(function(){
		$('[name="section"]').change(function(){
			var id = $(this).val();
			if (id == "0") {
				alert("请选择")
			}else{
				var xhr = null;
				if(window.XMLHttpRequest){
					//1.实例化
					xhr = new XMLHttpRequest();
					//2.创建请求
					xhr.open("get","section?usr=select&id="+id,true);
					//3发送请求,get必须为null
					xhr.send(null);
					//回调
					xhr.onreadystatechange = function () {
						//就绪码
						if(xhr.readyState == "4" && xhr.status == "200"){
							var rs = xhr.responseText;
							console.log(rs);
							var jos = eval('('+rs+')')
							var staff = $('[name="staff"]');
							staff.children().remove();
							for (var i = 0; i < jos.length; i++) {
								var otin = $("<option>");
								otin.val(jos[i].id);otin.html(jos[i].name)
								staff.append(otin);
							}
						}else if(xhr.status == 404){
							alert("资源不存在")
						}else if(xhr.status == 500){
							alert("服务区内部出错")
						}
					}
				}
			}
		});
	})
</script>
<body>
	<div>
		<p><span>部门</span> 
				<select name="section">
					<option value="0">请选择</option>
				<c:forEach items="${sectionlist}" var="l">
					<option value="${l.id}">${l.name}</option>
				</c:forEach>
				</select>
			<span>职员</span>
			<select name="staff">
			</select>
		</p>
	</div>
</body>
</html>