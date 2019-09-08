<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Forms</title>
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
	name='viewport' />
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
<link rel="stylesheet" href="assets/css/ready.css">
<link rel="stylesheet" href="assets/css/demo.css">
	<style type="text/css">
		.ji1,.jia1{
			float: right;
			margin: 10px;
		}
	</style>
</head>
<body>
	<div class="content">
		<div class="container-fluid">
			<h4 class="page-title">创建投票</h4>
			<div class="row">
				<div class="col-md-6">
					<div class="card">
						<div class="card-header">
							<div class="card-title">问卷归类</div>
						</div>
						<div class="card-body">
							<div class="form-group">
								<label for="solidSelect">请选择该分类的类型</label> <select
									class="form-control input-solid" id="aselect">
									<option value="0">调查</option>
									<option value="1">投票</option>
							</select>
							</div>
							<div class="form-group">
								<label for="email">请为该类取个名字</label> <input type="text"
									class="form-control" id="gname" name="gname" placeholder="Name">
								<small id="emailHelp" class="form-text text-muted">Please
									give me a name.</small>
							</div>
							<div class="form-group">
								<label for="comment">介绍:</label>
								<textarea class="form-control" id="gref" rows="5" name="gref"></textarea>
							</div>
							<div class="form-group">
								<label for="pillInput">开始时间</label> <input type="date"
									class="form-control input-pill" id="vstarttime">
							</div>
							<div class="form-group">
								<label for="pillInput">截至时间</label> <input type="date"
									class="form-control input-pill" id="vdeadline">
							</div>
							<div class="form-check">
								<label class="form-check-label"> <input
									class="form-check-input" type="checkbox" value="" id="yes">
									<span class="form-check-sign">不勾选表示所有人可投票.</span>
								</label>
							</div>
						</div>
						<div class="card-action">
							<button class="btn btn-success" id="gsubmit">Submit</button>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="card" id="formsjik">
						<div class="card-header">
							<div class="card-title">新建投票</div>
						</div>
						<div class="card-body">
							<div class="form-group">
								<label for="solidSelect">请选择该问卷的分类</label> <select
									class="form-control input-solid" id="solidSelect">

								</select>
							</div>
							<div class="form-group">
								<label for="pillInput">请填写问题</label> <input type="text"
									class="form-control input-pill" id="vissue"
									placeholder=" 列:明天天气怎么样?">
							</div>
							<div class="form-group xuanliqi">
								<label for="pillInput">请填写选项</label> <input type="text"
									class="form-control input-pill voptionA" placeholder=" 列:天晴">
								<!--<span class="badge badge-default jia">+</span>-->
								<!--<span class="badge badge-default jian">-</span>-->
							</div>
							<div class="form-group xuanliqi">
								<label for="pillInput">请填写选项</label> <input type="text"
									class="form-control input-pill voptionA" placeholder=" 列:天晴">
								<span class="badge badge-default ji1">+</span> <span
									class="badge badge-default jia1">-</span>
							</div>

						</div>
						<div class="card-action">
							<button class="btn btn-success" id="wan">完成</button>
							<button class="btn btn-danger" id="wang">完成并再创建</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
<script src="assets/js/core/jquery.3.2.1.min.js"></script>
<script src="assets/js/plugin/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
<script src="assets/js/core/popper.min.js"></script>
<script src="assets/js/core/bootstrap.min.js"></script>
<script src="assets/js/plugin/chartist/chartist.min.js"></script>
<script src="assets/js/plugin/chartist/plugin/chartist-plugin-tooltip.min.js"></script>
<script src="assets/js/plugin/bootstrap-notify/bootstrap-notify.min.js"></script>
<script src="assets/js/plugin/bootstrap-toggle/bootstrap-toggle.min.js"></script>
<script src="assets/js/plugin/jquery-mapael/jquery.mapael.min.js"></script>
<script src="assets/js/plugin/jquery-mapael/maps/world_countries.min.js"></script>
<script src="assets/js/plugin/chart-circle/circles.min.js"></script>
<script src="assets/js/plugin/jquery-scrollbar/jquery.scrollbar.min.js"></script>
<script src="liqi/for.js" type="text/javascript" charset="utf-8"></script>
<script src="assets/js/ready.min.js"></script>
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
<link rel="stylesheet" href="assets/css/ready.css">
<link rel="stylesheet" href="assets/css/demo.css">
<%--<link rel="stylesheet" type="text/css" href="liqi/bu.css" />--%>
</html>
