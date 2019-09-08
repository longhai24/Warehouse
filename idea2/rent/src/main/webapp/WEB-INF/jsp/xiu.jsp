<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK rel=stylesheet type=text/css href="css/style.css">
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
					<DT>修改房屋信息发布</DT>
					<DD class=past>填写房屋信息</DD>
				</DL>
				<DIV class=box>
					<FORM id=add_action method=post name="add" action="user?usr=modifyHouse">
						<DIV class=infos>
							<TABLE class=field>
								<TBODY>
									<tr>
										<TD class=field>图片：</TD>
										<td><input type="file" name="himg">
											<input type="hidden" name="hid" value="${h.hid}">
										</td>
										<td><img src="${h.himg}" name="img" width="100px" height="100px" /></td>
									</tr>
									<TR>
										<TD class=field>标 题：</TD>
										<TD>
											<INPUT id=add_action_title class=text type=text name=title value="${h.htitle}">
										</TD>
									</TR>
									<TR>
										<TD class=field>户 型：</TD>
										<TD>
											<SELECT class=text name=type_id>
												<c:forEach items="${housetypelist}" var="o">
													<OPTION selected value="${o.tid}">${o.tname}</OPTION>
												</c:forEach>
											</SELECT>
										</TD>
									</TR>
									<TR>
										<TD class=field>面 积：</TD>
										<TD>
											<INPUT id=add_action_floorage class=text type=text name=floorage value="${h.hacreage}">
										</TD>
									</TR>
									<TR>
										<TD class=field>价 格：</TD>
										<TD>
											<INPUT id=add_action_price class=text type=text name=price value="${h.hprice}">
										</TD>
									</TR>
									<TR>
										<TD class=field>房产证日期：</TD>
										<TD>
											<INPUT class=text type=text name=houseDate value="<fmt:formatDate value="${h.htime}" pattern="yyyy-MM-dd"/>">
										</TD>
									</TR>
									<TR>
										<TD class=field>位 置：</TD>
										<TD>
											<SELECT class=text name="district_id">
												<c:forEach items="${dislist}" var="d">
													<OPTION selected value="${d.did}">${d.dname}</OPTION>
												</c:forEach>
											</SELECT>区 
											<SELECT class=text name="street_id">
												<c:forEach items="${Streetlist}" var="s">
													<OPTION selected value="${s.sid}">${s.sname}</OPTION>
												</c:forEach>
											</SELECT>街
										</TD>
									</TR>
									<!-- 
						<tr>
							<td class="field">坐  标：</td>
							<td><input type="text" class="text" name="point" />
							</td>
						</tr>
						-->
									<!--  <tr>
							<td class="field">Y 坐  标：</td>
							<td><input type="text" class="text" name="point.y" /></td>
						</tr>-->
									<TR>
										<TD class=field>联系方式：</TD>
										<TD>
											<INPUT id=add_action_contact class=text type=text name=contact value="${h.hphone}" />
										</TD>
									</TR>
									<TR>
										<TD class=field>详细信息：</TD>
										<TD>
											<TEXTAREA name=description>${h.hdetails}</TEXTAREA>
										</TD>
									</TR>
								</TBODY>
							</TABLE>
							<DIV class=buttons>
								<INPUT value=立即发布 type="submit">
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
	<script src="js/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
			$('[name="district_id"]').val(${h.pla.did});
			$('[name="street_id"]').val(${h.pla.sid})
			$('[name=type_id]').val(${h.htype.tid});
		$('[name="district_id"]').bind('change', function() {
			var did = $(this).val();
			$('[name="street_id"]').children().remove();
			$.ajax({
				url: "user?usr=findstreed",
				data: {
					"did": did
				},
				type: "post",
				dataType: "json",
				success: function(result) {
					if("" == result) {
						$('[name="street_id"]').append($('<OPTION selected value="0">大街</OPTION>'))
					} else {
						$.each(result, function(i, j) {
							var se = $("<OPTION selected ></OPTION>")
							se.val(j.sid)
							se.html(j.sname)
							$('[name="street_id"]').append(se)
						});
					}
				}
			});
		})

		$('[name="himg"]').on('change', function() {
			var th = $(this);
			var filePath = $(this).val(), //获取到input的value，里面是文件的路径
				fileFormat = filePath.substring(filePath.lastIndexOf(".")).toLowerCase(),
				src = window.URL.createObjectURL(this.files[0]); //转成可以在本地预览的格式
			// 检查是否是图片
			//		alert(filePath)
			if(!fileFormat.match(/.png|.jpg|.jpeg/)) {
				alert("上传错误,文件格式必须为：png/jpg/jpeg")
				return;
			} else {
				$('[name="img"]').attr("src", src);
				var f = $('[name="add"]');
				var form = new FormData(f[0]);
				$.ajax({
					url: "user?usr=sfile",
					data: form,
					processData: false,
					type: "post",
					contentType: false,
					success: function(result) {}

				});
			}
		});
	</script>

</html>