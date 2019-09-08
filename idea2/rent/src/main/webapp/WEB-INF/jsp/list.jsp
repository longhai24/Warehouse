<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK rel=stylesheet type=text/css href="css/style.css">
<title>Insert title here</title>
</head>
<body>
<a href="user?usr=findProvices">选着位置</a>
	<DIV id=header class=wrap>
		<DIV id=logo>
			<IMG src="images/logo.gif">
		</DIV>
	</DIV>
	<DIV id=navbar class=wrap>
		<DL class="search clearfix">
			<FORM id=sform method=post action="user?usr=likeHouses">
				<DT>
					<UL>
						<LI class=bold>房屋信息</LI>
						<LI>标题：<INPUT class=text type=text name=name> <LABEL
							class=ui-blue><INPUT value=搜索房屋 type="submit" name=search></LABEL>
						</LI>
					</UL>
				</DT>
				<DD>
					<UL>
						<LI class=first>价格</LI>
						<LI><input type="text" name="minprice" width="50px">
							- <input type="text" name="maxprice" width="50px"></LI>
					</UL>
				</DD>
				<DD>
					<UL>
						<LI class=first>房屋位置</LI>
						<LI><SELECT class=text name="district_id">
								<c:forEach items="${dislist}" var="d">
									<OPTION selected value="${d.did}">${d.dname}</OPTION>
								</c:forEach>
						</SELECT> 街： <SELECT class=text name="street">
								<OPTION selected value="">大街</OPTION>
						</SELECT></LI>
					</UL>
				</DD>
				<DD>
					<UL>
						<LI class=first>房型</LI>
						<LI><SELECT name=htype>
						<OPTION value="">不选择</OPTION>
								<c:forEach items="${housetypelist}" var="o">
									<OPTION selected value="${o.tid}">${o.tname}</OPTION>
								</c:forEach>
						</SELECT></LI>
					</UL>
				</DD>
				<DD>
					<UL>
						<LI class=first>面积</LI>
						<LI><input type="text" name="acreage"></LI>
					</UL>
				</DD>
			</FORM>
		</DL>
	</DIV>
	<DIV class="main wrap">
		<TABLE class=house-list>
			<TBODY>
				<c:forEach items="${houses}" var="h">
					<TR>
						<TD class=house-thumb><span><A href="details.htm"
								target="_blank"><img src="${h.himg}" width="100" height="75"
									alt=""></a></span></TD>
						<TD>
							<DL>
								<DT>
									<A href="user?usr=findHouse&id=${h.hid}" target="_blank">${h.htitle}</A>
								</DT>
								<DD>
									${h.pla.dname}区 ${h.pla.sname}街;${h.hacreage}平方米 <br />
									联系方式:${h.hphone}
								</DD>
							</DL>
						</TD>
						<TD class=house-type>${h.htype.tname}</TD>
						<TD class=house-price><SPAN>${h.hprice}</SPAN>元/月</TD>
					</TR>
				</c:forEach>

			</TBODY>
		</TABLE>
		<DIV class=pager>
			<UL>
				<LI class=current><A href="#">首页</A></LI>
				<LI><A href="user?usr=likeCaoPage&cao=prev">上一页</A></LI>
				<LI><A href="user?usr=likeCaoPage&cao=next">下一页</A></LI>
				<LI><A href="#">末页</A></LI>
			</UL>
			<SPAN class=total>1/2页</SPAN>
		</DIV>
	</DIV>
	<DIV id=footer class=wrap>
		<DL>
			<DT>青鸟租房 © 2010 北大青鸟 京ICP证1000001号</DT>
			<DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD>
		</DL>
	</DIV>
</body>
<script src="js/jquery-1.8.3.min.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript">
	$('[name="district_id"]').bind('change', function() {
		alert("213")
			var did = $(this).val();
			$('[name="street"]').children().remove();
			$.ajax({
				url: "user?usr=findstreed",
				data: {
					"did": did
				},
				type: "post",
				dataType: "json",
				success: function(result) {
					if("" == result) {
						$('[name="street"]').append($('<OPTION selected >大街</OPTION>'))
					} else {
						$.each(result, function(i, j) {
							var se = $("<OPTION selected ></OPTION>")
							se.val(j.sid)
							se.html(j.sname)
							$('[name="street"]').append(se)
						});
					}
				}
			});
		})
</script>
</html>