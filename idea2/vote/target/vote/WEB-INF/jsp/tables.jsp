<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>Tables</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
          name='viewport'/>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="assets/css/ready.css">
    <link rel="stylesheet" href="assets/css/demo.css">
    <link rel="stylesheet" type="text/css" href="liqi/bu.css" />
</head>

<body>
<div class="content">
    <div class="container-fluid">
        <h4 class="page-title">Tables</h4>
        <div class="row">
            <!--左-->
            <div class="col-md-6">
                <!--//投票桶顶-->
                <div class="card">
                    <div class="card-header">
                        <div class="card-title">投票桶</div>
                    </div>
                    <div class="card-body">
                        <div class="card-sub">
                            每个问题投票对应一个桶 <code class="highlighter-rouge">一个桶最多添加50张投票项</code> <code
                                class="highlighter-rouge"></code> 下面可以对发布的投票进行管理
                        </div>
                        <div class="table-responsive">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th>#编号</th>
                                    <th>名称</th>
                                    <th>介绍</th>
                                    <th>状态</th>
                                    <th>修改</th>
                                    <th>查看</th>
                                </tr>
                                </thead>
                                <tbody id="vptd">
                                <c:forEach items="${pagainfo.list}" var="l">
                                    <tr>
                                        <th>${l.vpid}</th>
                                        <td>${l.vpname}</td>
                                        <td>${l.vptrace}</td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${l.vstatus == 0}">运行</c:when>
                                                <c:otherwise>
                                                    截至
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td><span class="badge badge-primary gliqixg">修改</span></td>
                                        <td><span class="badge badge-primary gliqixr">查阅</span></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!--//投票桶分页-->
                <div class="card-body">
                    <p class="demo">
                    <ul class="pagination pg-primary">
                        <li class="page-item">
                            <a class="page-link vppage prvepage" aria-label="${pagainfo.prePage}">
                                <span aria-hidden="true">&laquo;</span>
                                <span class="sr-only">Previous</span>
                            </a>
                        </li>
                        <li class="page-item active">
                            <a class="page-link" href="#">1</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="#">2</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="#">3</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link vppage nextpage"  aria-label="${pagainfo.nextPage}">
                                <span aria-hidden="true">&raquo;</span>
                                <span class="sr-only">Next</span>
                            </a>
                        </li>
                    </ul>
                    </p>
                </div>
                <!--//修改投票桶-->
                <div class="card gxiugai">
                    <div class="card-header">
                        <div class="card-title">问卷归类</div>
                        <input type="hidden" id="gid" value=""/>
                    </div>
                    <div class="card-body">
                        <div class="form-group">
                            <label for="email">请为该类取个名字</label>
                            <input type="text" class="form-control" id="gname" name="gname" placeholder="Name">
                            <small id="emailHelp" class="form-text text-muted">Please give me a name.</small>
                        </div>
                        <div class="form-group">
                            <label for="comment">介绍:</label>
                            <textarea class="form-control" id="gref" rows="5" name="gref">

												</textarea>
                        </div>
                        <div class="form-group">
                            <label for="pillInput">开始时间</label>
                            <input type="date" class="form-control input-pill" id="vstarttime">
                        </div>
                        <div class="form-group">
                            <label for="pillInput">截至时间</label>
                            <input type="date" class="form-control input-pill" id="vdeadline">
                        </div>
                        <div class="form-check">
                            <label class="form-check-label">
                                <input class="form-check-input" type="checkbox" value="" id="yes">
                                <span class="form-check-sign">选中公开,否者团队投</span>
                            </label>
                        </div>
                    </div>
                    <div class="card-action">
                        <button class="btn btn-success" id="gsubmit">Submit</button>
                    </div>
                </div>

            </div>
            <!--右-->
            <div class="col-md-6">
                <!--投票显示-->
                <div class="card">
                    <div class="card-header">
                        <div class="card-title">投票信息管理</div>
                    </div>
                    <div class="card-body">
                        <table class="table table-head-bg-primary mt-4">
                            <thead>
                            <tr>
                                <th scope="col">#编号</th>
                                <th scope="col">问题</th>
                                <th scope="col">选项一</th>
                                <th scope="col">选项二</th>
                                <th scope="col">操作</th>
                                <th scope="col">操作</th>
                            </tr>
                            </thead>
                            <tbody id="votd">
                            <tr>
                                <td>1</td>
                                <td>明天天气</td>
                                <td>2019-12-00</td>
                                <td>2019-12-15</td>
                                <td>进行</td>
                                <td><span class="badge badge-primary voteupdate">修改</span></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <!--投票分页-->
                <div class="card-body">
                    <p class="demo">
                    <ul class="pagination pg-primary">
                        <li class="page-item">
                            <a class="page-link voprevpage mnbjj" href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                                <span class="sr-only">Previous</span>
                            </a>
                        </li>
                        <li class="page-item active">
                            <a class="page-link" href="#">1</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="#">2</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="#">3</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link vonextpage mnbjj" href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                                <span class="sr-only">Next</span>
                            </a>
                        </li>
                    </ul>
                    </p>
                </div>
                <!--修改投票-->
                <div class="card liqitpxg">
                    <div class="card-header">
                        <div class="card-title">修改投票管理</div>
                    </div>
                    <div class="card-body">
                        <div class="form-group">
                            <label for="solidSelect">请选择该问卷的分类</label>
                        </div>
                        <div class="form-group">
                            <label for="pillInput">请填写问题</label>
                            <input type="text" class="form-control input-pill" id="vissue" placeholder=" 列:明天天气怎么样?">
                        </div>
                        <div class="form-group xuanliqi">
                            <label for="pillInput">请填写选项</label>
                            <input type="text" class="form-control input-pill voptionA" placeholder=" 列:天晴">
                            <!--<span class="badge badge-default jia">+</span>-->
                            <!--<span class="badge badge-default jian">-</span>-->
                        </div>
                        <div class="form-group xuanliqi">
                            <label for="pillInput">请填写选项</label>
                            <input type="text" class="form-control input-pill voptionA" placeholder=" 列:天晴">
                            <span class="badge badge-default jia">+</span>
                            <span class="badge badge-default jian">-</span>
                        </div>
                        <div class="form-group xuanliqi">
                            <label for="pillInput">请填写选项</label>
                            <input type="text" class="form-control input-pill voptionA" placeholder=" 列:天晴">
                            <span class="badge badge-default jia">+</span>
                            <span class="badge badge-default jian">-</span>
                        </div>
                        <div class="form-group xuanliqi">
                            <label for="pillInput">请填写选项</label>
                            <input type="text" class="form-control input-pill voptionA" placeholder=" 列:天晴">
                            <span class="badge badge-default jia">+</span>
                            <span class="badge badge-default jian">-</span>
                        </div>
                        <div class="form-group xuanliqi">
                            <label for="pillInput">请填写选项</label>
                            <input type="text" class="form-control input-pill voptionA" placeholder=" 列:天晴">
                            <span class="badge badge-default jia">+</span>
                            <span class="badge badge-default jian">-</span>
                        </div>
                    </div>
                    <div class="card-action">
                        <button class="btn btn-success" id="wan">修改</button>
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
<link rel="stylesheet" type="text/css" href="liqi/table.css"/>
<script src="assets/js/ready.min.js"></script>
<script src="liqi/table.js" type="text/javascript" charset="utf-8"></script>
<script>
    $('#displayNotif').on('click', function () {
        var placementFrom = $('#notify_placement_from option:selected').val();
        var placementAlign = $('#notify_placement_align option:selected').val();
        var state = $('#notify_state option:selected').val();
        var style = $('#notify_style option:selected').val();
        var content = {};

        content.message = 'Turning standard Bootstrap alerts into "notify" like notifications';
        content.title = 'Bootstrap notify';
        if (style == "withicon") {
            content.icon = 'la la-bell';
        } else {
            content.icon = 'none';
        }
        content.url = 'index.html';
        content.target = '_blank';

        $.notify(content, {
            type: state,
            placement: {
                from: placementFrom,
                align: placementAlign
            },
            time: 1000,
        });
    });
</script>

</html>