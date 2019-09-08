<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="/firstlesson/static/js/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$(function(){
		$(".mm").click(function(){
			var the = $(this);
			var name = $(this).parents("tr").find("td").eq(1).html();
			alert(name)
			var aler = $(this).parents("tr").next().attr("class");
			if(aler == undefined){
				var tr = $("<tr class='ll'>").html("正在努力加载中.....");
				$(this).parents("tr").after(tr);
			}
			
			
			
		var xhr = null;
		if(window.XMLHttpRequest){
			//1实例化
			xhr  = new XMLHttpRequest();
			//2创建请求
			xhr.open("post","staff?usr=select",true);
			//设置编码
			xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			//3发送请求,get必须为null
			xhr.send("name="+name);
			xhr.onreadystatechange  = function(){
				//就绪码
				if(xhr.readyState == 4){
					if(xhr.status == 200){
 						var rs = xhr.responseText; // 文本
						console.log(rs);
						var jso = eval('('+rs+')')
						console.log(jso[0].id);
						var llp = "编号:"+jso[0].id+"姓名:"+jso[0].name+"地址:"+jso[0].site+"Eamil:"+jso[0].emial;
						the.parents("tr").next().html(llp)
					}else if(xhr.status == 404){
						alert("资源不存在")
					}else if(xhr.status == 500){
						alert("服务器出错")
					}
				}
			}
		}
		})
	})
</script>
</head>
<body>
	<table border="" cellspacing="" cellpadding="">
		<thred>
			<tr>
				<th>
					编号
				</th>
				<th>
					姓名
				</th>
				<th>
					操作
				</th>
			</tr>
		</thred>
		<tbody>
		<c:forEach items="${list}" var="l">
			<tr>
				<td>${l.id}</td>
				<td>${l.name}</td>
				<td class="mm">查看详情</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>