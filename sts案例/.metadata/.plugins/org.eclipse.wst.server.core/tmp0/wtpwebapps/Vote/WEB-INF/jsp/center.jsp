<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
		<link rel="stylesheet" href="css/page.css" />
		<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="js/index.js"></script>
		<link href="css/show.css" />
</head>
<body>
	<div class="left">
		<div class="bigTitle">投票管理系统</div>
		<div class="lines">
			<div onclick="pageClick(this)" class="active">
				<img src="img/icon-1.png" />新增投票
			</div>
			<div onclick="pageClick(this)">
				<img src="img/icon-2.png" />管理投票
			</div>
			<div onclick="pageClick(this)">
				<a onclick=""></a><img src="img/icon-3.png" />查看投票信息
			</div>

		</div>
	</div>
	<div class="top">
		<div class="leftTiyle" id="flTitle">投票管理</div>
		<div class="thisUser">当前用户：小UU</div>
	</div>
	<div class="content" style="display: none;">
		<div>新增</div>
	</div>
	<div class="content1" style="display: none;">管理投票</div>
	<div class="content2" style="display: none;"></div>
</body>
</html>