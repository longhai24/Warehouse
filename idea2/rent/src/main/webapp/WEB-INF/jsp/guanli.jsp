<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<LINK rel=stylesheet type=text/css href="css/style.css">
<title>Insert title here</title>
</head>
<body>
<a href="user?usr=findProvices">选着位置</a>
	<DIV id=header class=wrap>
		<DIV id=logo>
			<IMG src="images/logo.gif">
		</DIV>
		<DIV class=search>
			<LABEL class="ui-green searchs"><a href="user?usr=skip-fabu" title="">发布房屋信息</a></LABEL>
			<LABEL class=ui-green><INPUT
				onclick='document.location="index.jsp"' value="退       出"
				type=button name=search></LABEL>
		</DIV>
	</DIV>
	<DIV class="main wrap">
		<DIV id=houseArea>
			<TABLE class=house-list>
				<TBODY>
				<c:forEach items="${Houselist}" var="h">
					<TR>
						<TD class=house-thumb><SPAN><A href="user?usr=findHouse&id=${h.hid}"
								target="_blank"><img src="${h.himg}"
									width="100" height="75" alt=""></A></SPAN>
										<input type="hidden" name="hid" value="${h.hid}">
									</TD>
						<TD>
							<DL>
								<DT>
									<A href="user?usr=findHouse&id=${h.hid}" target="_blank">${h.htitle}</A>
								</DT>
								<DD>
									${h.pla.dname}区 ${h.pla.sname}街
									<br/>
									联系方式:${h.hphone}
								</DD>
							</DL>
						</TD>
						<TD class=house-type><LABEL class=ui-green><a href="user?usr=xiu&hid=${h.hid}"><INPUT value="修    改" type=button ></a></LABEL></TD>
						<TD class=house-price><LABEL class=ui-green><INPUT
								value="删    除" type=button name='search'></LABEL></TD>
					</TR>
				</c:forEach>
					
				</TBODY>
			</TABLE>
		</DIV>
		<DIV class=pager>
			<UL>
				<LI class=current><A id=widget_338868862
					href="user?usr=guanlicCaoPage&cao=prev"
					parseContent="true" showError="true" targets="houseArea"
					ajaxAfterValidation="false" validate="false"
					dojoType="struts:BindAnchor">上一页</A></LI>
				<LI class=current><A id=widget_1160989910
					href="user?usr=guanlicCaoPage&cao=next"
					parseContent="true" showError="true" targets="houseArea"
					ajaxAfterValidation="false" validate="false"
					dojoType="struts:BindAnchor">下一页</A></LI>
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
</BODY>
<script src="js/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$("[name='search']").click(function(){
		if(confirm("確定要刪除条记录")){
			var hid = $(this).parents("tr").find($('[name="hid"]')).val();
			var thi = $(this);
			$.ajax({
				type:"post",
				url:"user?usr=removeHouse",
				data:{'hid':hid},
				dataType:"text",
				success:function(data){
					if("ok" == data){
						alert("刪除成功");
						thi.parents("tr").remove()
					}
				}
			});
			}
	})
	 $.getScript('http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js', function(_result) {
            if (remote_ip_info.ret == '1') {
                alert('国家：' + remote_ip_info.country + '<BR>省：' + remote_ip_info.province + '<BR>市：' + remote_ip_info.city + '<BR>区：' + remote_ip_info.district + '<BR>ISP：' + remote_ip_info.isp + '<BR>类型：' + remote_ip_info.type + '<BR>其他：' + remote_ip_info.desc);
            } else {
                alert('没有找到匹配的IP地址信息！');
            }
        });
</script>
</body>
</html>