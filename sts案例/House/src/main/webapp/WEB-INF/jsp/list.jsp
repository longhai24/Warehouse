<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	</DIV>
	<DIV id=navbar class=wrap>
		<DL class="search clearfix">
			<FORM id=sform method=post action=HouseAction>
				<DT>
					<UL>
						<LI class=bold>房屋信息</LI>
						<LI>标题：<INPUT id=title class=text type=text name=title> <LABEL
							class=ui-blue><INPUT id = seltitle value=搜索房屋
								type=button name=search></LABEL>
						</LI>
					</UL>
				</DT>
				<DD>
					<UL>

						<LI class=first>价格</LI>
						<LI><input id=money type="text" style="width:50%">
						</SELECT></LI>
					</UL>
				</DD>
				<DD>
					<UL>
						<LI class=first>省份</LI>
						<LI><SELECT id=pro name=street_id>
						<option>请选择</option>
						</SELECT></LI>
					</UL>
				</DD>
				<DD>
					<UL>
						<UL>
							<LI class=first>市区</LI>
							<LI><SELECT id=dow name=street_id>
									<option id="">请选择</option>
							</SELECT></LI>
						</UL>
				</DD>
				<DD>
					<UL>
						<LI class=first>街道</LI>
						<LI><SELECT id=str name=street_id>
								<option id="">请选择</option>
						</SELECT></LI>
					</UL>
				</DD>
				<DD>
					<UL>
						<UL>
							<LI class=first>房型</LI>
							<LI><SELECT name=type_id id=typ><option id="">请选择</option></SELECT>
							</LI>
						</UL>
				</DD>
				
			</FORM>
		</DL>
	</DIV>
	<DIV class="main wrap">
		<TABLE class=house-list>
			<TBODY>

				
				<c:forEach items="${show}" var="a">

					<TR class=odd>
						<TD class=house-thumb><span><A href="details.htm"
								target="_blank"><img src="${a.hpic }" width="100"
									height="75" alt=""></a></span></TD>
						<TD>
							<DL>
								<DT>
									<A href="details.htm" target="_blank">${a.htit }</A>
								</DT>
								<DD>${a.hinf }<BR>联系方式：${a.hpho }
								</DD>
							</DL>
						</TD>
						<TD class=house-type>${a.mname }</TD>
						<TD class=house-price><SPAN>${a.hpri }</SPAN>元/月</TD>
					</TR>
				</c:forEach>
				<TR>无租房信息
				</TR>
			</TBODY>
		</TABLE>
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
	$("#typ").change(function() {
		var txt = $(this).val();
		$.ajax({
			url:"HouseAction",
			data:{method:"SelSomHouByTitle",typ:txt},
			type:"post",
			success: function (data) {
				traversal(data)
			}
		})
	})

	$("#str").change(function() {
		var txt = $(this).val();
		$.ajax({
			url:"HouseAction",
			data:{method:"SelSomHouByTitle",str:txt},
			type:"post",
			success: function (data) {
				traversal(data)
			}
		})
		
	})

	$.ajax({
		url:"HouseAction",
		data:{method:"SelAllType"},
		type:"post",
		dataType:"json",
		success: function(data) {
			for ( var i in data) {
				var opt = $("<option value="+data[i].type_id+">"+data[i].type_name+"</option>")
				$("#typ").append(opt)
			}
		}
	})
	
	$("#money").blur(function() {
		var mon = $(this).val();
		$.ajax({
			url:"HouseAction",
			data:{method:"SelSomHouByTitle",mon:mon},
			type:"post",
			success: function (data) {
				traversal(data)
			}
		})
	})
$("#seltitle").click(function() {
	var txt = $("#title").val()
	$.ajax({
		url:"HouseAction",
		data:{method:"SelSomHouByTitle",txt:txt},
		type:"post",
		success: function(data) {
			traversal(data)
		}
	})
	return false;
})
$("#pro").change(function() {
	if ($("#pro option").val()=="请选择") {
		$("#dow option").remove();
	}
	var txt = $(this).val()
	var wo = $("#pro").val()
	$.ajax({
		url:"HouseAction",
		data:{method:"SelSomHouByTitle",pro:txt},
		type:"post",
		success: function(data) {
			traversal(data)
		}
	})
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
$("#dow").change(function() {
	var wo = $("#dow").val()
	var txt = $(this).val()
	$.ajax({
		url:"HouseAction",
		data:{method:"SelSomHouByTitle",dow:txt},
		type:"post",
		success: function(data) {
			traversal(data)
		}
	})
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
	
	
	$("a").click(function() {
		return false;
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
					var tr = $("<tr class=odd></tr>")
					var td1 = $("<TD class=house-thumb><span><A href='details.htm' target='_blank'><img src='"+ndata[i].hpic+"' width='100' height='75' alt=''></a></span></TD>")
					var td2 = $("<TD><DL><DT><A href='details.htm' target='_blank'>"+ndata[i].htit+"</A></DT><DD>"+ndata[i].hinf+"<BR>联系方式："+ndata[i].hpho+"</DD></DL></TD>")
					var td3 =$("<TD class=house-type>"+ndata[i].mname+"</TD>")
					var td4 = $("<TD class=house-price><SPAN>"+ndata[i].hpri+"</SPAN>元/月</TD>")
					tr.append(td1).append(td2).append(td3).append(td4)
					$("tbody").append(tr)
				}
	}
	
</script>
</html>