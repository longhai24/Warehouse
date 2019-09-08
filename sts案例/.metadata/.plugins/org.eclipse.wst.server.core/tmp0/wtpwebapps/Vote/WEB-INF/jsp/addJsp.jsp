<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/fileinput.min.css" rel="stylesheet">
    <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.6.0/css/font-awesome.min.css">
    <link href="form_builder/animate.min.css" rel="stylesheet">
    <link href="form_builder/summernote.css" rel="stylesheet">
		
    <link href="form_builder/style.min862f.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="javascript/fileinput.min.js"></script>
    <script src="javascript/bootstrap-datetimepicker.min.js"></script>
    <script src="javascript/distpicker.data.min.js"></script>
    <script src="javascript/distpicker.min.js"></script>
    <script src="javascript/bootstrap-datetimepicker.zh-CN.js"></script>
    <script src="javascript/zh.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="form_builder/beautifyhtml.js"></script>
    <script src="javascript/index.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid" style="padding: 0px; margin: 0px;">
		<div class="row-fluid clearfix">
			<div class="col-md-12 column">
				<div style="width: 1080px; margin: 0 auto; margin-top: 20px;">
					<div class="conference-cont" style="margin-top: 20px;">

						<div class="wrapper wrapper-content" style="margin-top: 55px;">
							<div class="row"
								style="border-left: 2px dashed rgba(0, 0, 0, 0.12); border-right: 2px dashed rgba(0, 0, 0, 0.12); border-bottom: 2px dashed rgba(0, 0, 0, 0.12);">
								<div id="colzuo" class="col-sm-9"
									style="border-right: 2px dashed rgba(0, 0, 0, 0.12);">
									<div class="ibox float-e-margins">
										<div class="ibox-title">
											<h5>拖拽/点击右侧表单项到此区域</h5>
											<div class="ibox-tools">
												<button type="submit" class="btn btn-warning"
													data-clipboard-text="testing" id="copy-to-clipboard">复制代码</button>
												<button type="button" class="btn btn-yulan">预览</button>
											</div>
										</div>
										<div class="ibox-content">
											<form action="VoteAction?method=AddVote" method="post">
												<div class="row form-body form-horizontal m-t">

													<input type="submit" onclick="alert('laile')" />

													<div
														class="col-md-12 droppable sortable ui-droppable ui-sortable">

													</div>
												</div>
											</form>

										</div>
									</div>
								</div>
								<div id="colyou" class="col-sm-3">
									<div class="ibox float-e-margins">
										<div class="ibox-title">
											<h5>自定义表单项</h5>
										</div>
										<div class="ibox-content">
											<form role="form" class="form-horizontal m-t">

												<p>
													<b>自定义项</b>
												</p>
												<div id="text"
													class="form-group draggable ui-draggable btntext">
													<label class="col-sm-12"><i class="fa fa-arrows"></i>
														文本框 <img src="image/add_form_img01.png"></label>
												</div>
												<div id="select"
													class="form-group draggable ui-draggable btntext">
													<label class="col-sm-12"><i class="fa fa-arrows"></i>
														下拉框 <img src="image/add_form_img05.png"></label>
												</div>
												<div id="radio"
													class="form-group draggable ui-draggable btntext">
													<label class="col-sm-12"><i class="fa fa-arrows"></i>
														单选 <img src="image/add_form_img03.png"></label>
												</div>
												<div id="checkbox"
													class="form-group draggable ui-draggable btntext">
													<label class="col-sm-12"><i class="fa fa-arrows"></i>
														多选 <img src="image/add_form_img04.png"></label>
												</div>
												<div id="textarea"
													class="form-group draggable ui-draggable btntext">
													<label class="col-sm-12"><i class="fa fa-arrows"></i>
														多行文本 <img src="image/add_form_img02.png"></label>
												</div>
												<div id="datetime"
													class="form-group draggable ui-draggable btntext">
													<label class="col-sm-12"><i class="fa fa-arrows"></i>
														时间 <img src="image/add_form_img06.png"></label>
												</div>
												<div id="file"
													class="form-group draggable ui-draggable btntext">
													<label class="col-sm-12"><i class="fa fa-arrows"></i>
														上传 <img src="image/add_form_img07.png"></label>
												</div>
												<div id="picker"
													class="form-group draggable ui-draggable btntext">
													<label class="col-sm-12"><i class="fa fa-arrows"></i>
														省市区 <img src="image/add_form_img08.png"></label>
												</div>
											</form>
											<div class="clearfix"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>