<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<LINK rel=stylesheet type=text/css href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<DIV id=header class=wrap>
		<DIV id=logo>
			<IMG src="images/logo.gif">
		</DIV>
	</DIV>
	<DIV id=regLogin class=wrap>
		<DIV class=dialog>
			<DL class=clearfix>
				<DT>新房屋信息发布</DT>
				<DD class=past>填写房屋信息</DD>
			</DL>
			<DIV class=box>
				<FORM id=add_action method=post name=add.action
					action=HouseAction?method=AddHouse enctype="multipart/form-data">
					<DIV class=infos>
						<TABLE class=field>
							<TBODY>
								<TR>
									<TD class=field>标 题：</TD>
									<TD><INPUT id=add_action_title class=text type=text
										name=title></TD>
								</TR>
								<TR>
									<TD class=field>户 型：</TD>
									<TD><SELECT class=text name=type_id>
									<c:forEach items="${typelist }" var="a">
									<option value="${a.type_id }">${a.type_name }</option>
									</c:forEach>
									</SELECT></TD>
								</TR>
								<TR>
									<TD class=field>面 积：</TD>
									<TD><INPUT id=add_action_floorage class=text type=text
										name=floorage></TD>
								</TR>
								<TR>
									<TD class=field>价 格：</TD>
									<TD><INPUT id=add_action_price class=text type=text
										name=price></TD>
								</TR>
								<TR>
									<TD class=field>选择图片：</TD>
									<TD><INPUT class=text type="file" name=houseDate></TD>
								</TR>
								<TR>
									<TD class=field>位 置：</TD>
									<TD>省份：<SELECT class=text name=pro id=pro><option>请选择</option></SELECT > 市区：<SELECT
										class=text name=dow id =dow></SELECT>街道：<SELECT class=text
										name=str id=str></SELECT>
									</TD>
								</TR>
								
								<TR>
									<TD class=field>联系方式：</TD>
									<TD><INPUT id=add_action_contact class=text type=text
										name=contact></TD>
								</TR>
								<TR>
									<TD class=field>详细信息：</TD>
									<TD><TEXTAREA name=description></TEXTAREA></TD>
								</TR>
							</TBODY>
						</TABLE>
						<DIV class=buttons>
							<INPUT  value=立即发布
								type="submit">
						</DIV>
					</DIV>
				</FORM>
			</DIV>
		</DIV>
	</DIV>
	<DIV id=footer class=wrap>
		<DL>
			<DT>青鸟租房 © 2010 北大青鸟 京ICP证1000001号</DT>
			<DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD>
		</DL>
	</DIV>
</body>
<script type="text/javascript" src="jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$.ajax({
		url:"HouseAction",
		data:{method:"SelProBy"},
		type:"post",
		dataType:"json",
		success: function (data) {
			for ( var i in data) {
				var opt = $("<option value="+data[i].province_id+">"+data[i].province_name+"</option>")
				$("#pro").append(opt)
			}
		}
	})
		
	$("#dow").change(function() {
		var wo = $("#dow").val()
		$.ajax({
			url:"HouseAction",
			data:{method:"SelStrBy",dowid:wo},
			type:"post",
			dataType:"json",
			success: function (data) {
				$("#str option").remove();
				for ( var i in data) {
				var opt = $("<option value="+data[i].street_id+">"+data[i].street_name+"</option>")
				$("#str").append(opt)
				}
			}
		})
		
	})
	
	$("#pro").change(function() {
		var wo = $("#pro").val()
		$.ajax({
			url:"HouseAction",
			data:{method:"SelDowBy",proid:wo},
			type:"post",
			dataType:"json",
			success: function (data) {
				$("#str option").remove();
				$("#dow option").remove();
				for ( var i in data) {
				var opt = $("<option value="+data[i].downtown_id+">"+data[i].downtown_name+"</option>")
				$("#dow").append(opt)
				}
			}
		})
		
	})
</script>
</html>