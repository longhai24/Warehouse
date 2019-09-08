<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<LINK rel=stylesheet type=text/css href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<DIV id=header class=wrap>
		<DIV id=logo>
			<IMG src="images/logo.gif">
		</DIV>
		<DIV class=search>
			<LABEL class="ui-green searchs"><a
				href="HouseAction?method=toAddHouse" title="">发布房屋信息</a></LABEL> <LABEL
				class=ui-green><INPUT value="退       出" type=button
				name=search></LABEL>
		</DIV>
	</DIV>
	<DIV class="main wrap">
		<DIV id=houseArea>
			<TABLE class=house-list>
				<TBODY>
					<c:forEach items="${myshow }" var="a">
						<tr id=${a.hid }>
							<TD class=house-thumb><SPAN><A href="" class =aaa1
									target="_blank"><img src="${a.hpic }" width="100"
										height="75" alt=""></A></SPAN></TD>
							<TD>
								<DL>
									<DT>
										<A href="HouseAction?method=todetails&uid=${a.hid }" target="_blank">${a.htit }</A>
									</DT>
									<DD>${a.hinf }<BR>联系方式：${a.hpho }
									</DD>

								</DL>
							</TD>
							<TD class=house-type><LABEL class=ui-green><INPUT
							class=upd	 value="修    改" type=button name=search></LABEL></TD>
							<TD class=house-price><LABEL class=ui-green><INPUT
									value="删    除" type=button name=search class=del></LABEL></TD>
						</tr>
					</c:forEach>

				</TBODY>
			</TABLE>
		</DIV>
		<DIV class=pager>
			<UL>
				<LI class=current><A href="#" class="a0">首页</A></LI>
				<LI><A href="#" id="a1">上一页</A></LI>
				<LI><A href="#" class="a2">下一页</A></LI>
				<LI><A href="#" class="a3">末页</A></LI>
			</UL>

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
$(document).on("click", ".upd", function(e) {
	var dhid = $(this).parent().parent().parent().attr("id")
	$.ajax({
		url:"HouseAction",
		data:{method:"SelHouOne",oneid:dhid},
		type:"post",
		dataType:"text",
		success: function(data) {
			window.sessionStorage.setItem("myhouse",data)
			
			window.location.href="HouseAction?method=toUpdate"
		}
	})
	
})	

		$(document).on("click", ".del", function(e) {
		var dhid = $(this).parent().parent().parent().attr("id")
		$.ajax({
			url:"HouseAction",
			data:{method:"delMyHouse",dhid:dhid},
			type:"post",
			success: function (data) {
				if (data=="删除成功") {
					window.location.href="http://localhost:8080/House/HouseAction?method=showMyAllHouse"
				}else  {
					alert("删除失败")
				}
			}
		})
	})	
	
	$(".a3").click(function () {
		$.ajax({
			url:"HouseAction",
			data:{method:"showLast"},
			type: "post",
			success: function(data) {
				traversal(data)
			}
		})
	})
	
	
	$(".a0").click(function() {
		$.ajax({
			url:"HouseAction",
			data:{method:"showFirst"},
			type: "post",
			success: function(data) {
				traversal(data)
			}
		})
	})
	
	$("#a1").click(function() {
		
		$.ajax({
			url:"HouseAction",
			data:{method:"showPrevious"},
			type: "post",
			success: function(data) {
				if (data=="b") {
					alert("当前已是第一页")
				}else{
					traversal(data)
			}
			}
		})
	
	})
	$(".a2").click(function() {
			
		$.ajax({
			url:"HouseAction",
			data:{method:"showNext"},
			type:"post",
			success: function (data) {
				if (data=="a") {
					alert("当前已是最后一页")
				}else{
					traversal(data)
			}}
		})
	
	})
	function traversal(data) {
		var  ndata= JSON.parse(data)
				$("tbody tr").remove();
				for (var i = 0; i < ndata.length; i++) {
					var tr = $("<tr id= "+ndata[i].hid+">")
					var td1 = $('<TD class=house-thumb> <SPAN><A href="" target="_blank"><img src="${a.hpic }" width="100" height="75" alt=""></A></SPAN></TD>')
					td1.find("img").attr("src",ndata[i].hpic);
					var td2 = $('<TD><DL><DT><A href="details.htm" target="_blank"></A></DT><DD><BR>联系方式：</DD></DL></TD>')
					td2.find("dt").find("a").html(ndata[i].htit); //标题
					td2.find("dt").find("a").attr("href","HouseAction?method=todetails&uid="+ndata[i].hid) //地址
					td2.find("dd").html(ndata[i].hinf+"<br/>"+"联系方式："+ndata[i].hpho);//
					var td3 = $('<TD class=house-type><LABEL class=ui-green><INPUT  value="修    改" type=button name=search class=upd></LABEL></TD>')
					var td4 = $('<TD class=house-price><LABEL class=ui-green><INPUT value="删    除" type=button name=search class=del></LABEL></TD>')
					tr.append(td1).append(td2).append(td3).append(td4)
					$("tbody").append(tr)
				}
	
	
	}
</script>
</html>