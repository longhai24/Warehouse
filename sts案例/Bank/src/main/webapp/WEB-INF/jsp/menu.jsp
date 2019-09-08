<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><%@ taglib prefix="fmt"
	uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<LINK rel=stylesheet type=text/css href="css/menu.css">
</head>
<body>
	<p>
		卡号：<span class=span1>${user.cardno }</span>
	</p>
	<a href=" " class=balance>查询余额</a>
	<a href=" " class=accounts>转账</a>
	<a href=" " class=record>查询交易记录</a>
	<a href=" " class=change>修改密码</a>
	<div class=fir>
		<p>欢迎使用网上银行</p>
	</div>
	<div class="sec">
		<p>
			您账户当前余额为：<span class=span2></span>
		</p>
	</div>
	<div class="thi">
		<p>当前操作：转账。请输入转入账号和金额后点击转账按钮</p>
		<form>
			<table>
				<tr>
					<td>转入账号</td>
					<td><input type="text" id=Intoaccount></td>
				</tr>
				<tr>
					<td>转账金额</td>
					<td><input type="text" id=Intomoney></td>
				</tr>
			</table>
			<input type="button" value="转账" class=transfer>
		</form>
	</div>
	<div class="fou">
		<p>当前操作：查询交易记录。请选择时间后点查询按钮</p>
		<input type="date" class=date1>到<input type="date" class=date2>
		<input type="button" value="查询" class=seldate>
		<table border=1px solid>
			<thead></thead>
			<tbody></tbody>
		</table>
	</div>
	<div class="fif">
		<p>当前操作：修改密码。按要求填写完整后 点修改按钮</p>
		<form>
			<table>
				<tr>
					<td>请输入现在的密码</td>
					<td><input type="text" class=pas1></td>
				</tr>
				<tr>
					<td>请输入新密码</td>
					<td><input type="text" class=newpas1></td>
				</tr>
				<tr>
					<td>请再输入新密码</td>
					<td><input type="text" class=newpas2></td>
				</tr>
				<tr>
					<td><input type="button" class=but1 value="提交"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(".but1").click(function() {
		var pas = $(".newpas1").val();
		var oldp = $(".pas1").val();
		$.ajax({
			url:"BankAction",
			data:{
				method:"updatePwd",
				newpas : pas,
				olopwd:oldp
			},
			type:"post",
			success: function(data) {
				alert(data);
			}
		
		})
	})
	$("a").click(function() {
		return false;
	})

	$(".change").click(function() {
		$(".sec").hide();
		$(".thi").hide();
		$(".fou").hide();
		$(".fir").hide();
		$(".fif").show();
	})
	$(".balance").click(function() {
		$(".sec").show();
		$(".thi").hide();
		$(".fou").hide();
		$(".fir").hide();
		$(".fif").hide();
	})
	$(".record").click(function() {
		$(".thi").hide();
		$(".fir").hide();
		$(".sec").hide();
		$(".fou").show();
		$(".fif").hide();
	})
	$(".accounts").click(function() {
		$(".thi").show();
		$(".fir").hide();
		$(".sec").hide();
		$(".fif").hide();
		$(".fou").hide();
	})

	$(".seldate").click(function() {
		var da = $(".date1").val()
		var da2 = $(".date2").val()
		$.ajax({
			url : "BankAction",
			data : {
				method : "selAllLog",
				date1 : da,
				date2 : da2
			},
			type : "post",
			dataType : "json",
			success : function(data) {
				tab(data);
			}

		})
	})
	$(".transfer").click(function() {
		var a = $("#Intoaccount").val();
		var b = $("#Intomoney").val();
		$.ajax({
			url : "BankAction",
			data : {
				Intoaccount : a,
				Intomoney : b,
				method : "transfer"
			},
			Type : "post",
			success : function(data) {
				if (data == "ok") {
					alert("成功")
				}
			}
		})

	})

	$(".balance").click(function() {
		var card = $(".span1").html();
		$.ajax({
			url : "BankAction",
			data : {
				method : "balance",
				card : card
			},
			type : "post",
			success : function(data) {
				$(".span2").html(data)
			}
		})
	})
	function tab(data) {
		$("tbody tr").remove();
		$("thead tr").remove();
		var th = $("<tr></tr>");
		var thd1 = $("<td>交易日期</td>");
		var thd2 = $("<td>支出</td>");
		var thd3 = $("<td>存入</td>");
		var thd4 = $("<td>账户余额</td>");
		var thd5 = $("<td>交易类型</td>");
		var thd6 = $("<td>备注</td>");
		th.append(thd1).append(thd2).append(thd3).append(thd4).append(thd5)
				.append(thd6)
		$("thead").append(th);
		var sum;
		for (var i = 0; i < data.length; i++) {
			var a = data[i];
			if (a.expense == "undefined") {
				sum = "";
			} else {
				sum = a.expense
			}
			var tr = $("<tr></tr>");
			var td1 = $("<td>" + timestampToTime(a.transaction_date) + "</td>");
			var td2 = $("<td>" + sum + "</td>");
			var td3 = $("<td>" + a.income + "</td>");
			var td4 = $("<td>" + a.balance + "</td>");
			var td5 = $("<td>" + a.transaction_type + "</td>");
			var td6 = $("<td>" + a.remark + "</td>");
			tr.append(td1).append(td2).append(td3).append(td4).append(td5)
					.append(td6)
			$("tbody").append(tr)
		}
		var atr = $("<tr></tr>");
		var atd1 = $("<td><a href='' class=firPage>首页</a>|<a href='' class=previousPage>上一页</a>|<a href=''class=nextPage>下一页</a>|<a href=''class=lasPage>尾页</a></td>")
		atr.append(atd1);
		$("tbody").append(atr)
	}

	function timestampToTime(timestamp) {
		var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
		Y = date.getFullYear() + '-';
		M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date
				.getMonth() + 1)
				+ '-';
		D = date.getDate() + ' ';
		h = date.getHours() + ':';
		m = date.getMinutes() + ':';
		s = date.getSeconds();
		return Y + M + D;
	}

	$(document).on("click", ".nextPage", function(e) {
		$.ajax({
			url : "BankAction",
			data : {
				method : "nextPage"
			},
			type : "post",
			dataType : "json",
			success : function(data) {

				tab(data)
			}
		})
		return false;
	})

	$(document).on("click", ".previousPage", function(e) {
		$.ajax({
			url : "BankAction",
			data : {
				method : "previousPage"
			},
			type : "post",
			dataType : "json",
			success : function(data) {

				tab(data)
			}
		})
		return false;
	})
</script>
</html>