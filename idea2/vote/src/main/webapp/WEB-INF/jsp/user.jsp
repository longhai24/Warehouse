<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="UTF-8">
    <title></title>
    <!--<link rel="stylesheet" href="css/bootstrap.min.css">-->
    <!--<link rel="stylesheet" href="assets/css/bootstrap.min.css">
            <link rel="stylesheet" href="assets/css/ready.css">
            <link rel="stylesheet" href="assets/css/demo.css">-->
    <script src="js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="liqi/user.js" type="text/javascript" charset="utf-8"></script>
</head>

<body>
<div class="content" style="margin-top: -10px;">
    <div class="main-content-container container-fluid px-4">
        <!-- Page Header -->
        <div class="page-header row no-gutters py-4">
            <div class="col-12 col-sm-4 text-center text-sm-left mb-0">
                <h3 class="page-title">用户资料</h3>
            </div>
        </div>
        <!-- End Page Header -->
        <!-- Default Light Table -->
        <div class="row">
            <div class="col-lg-4">
                <div class="card card-small mb-4 pt-3">
                    <div class="card-header border-bottom text-center">
                        <div class="mb-3 mx-auto">
                            <img class="rounded-circle" src="images/user.png" name="imguser"
                                 alt="User Avatar" width="110" style="width: 100px;height: 100px">
                        </div>
                        <h4 class="mb-0" id="name">李棋</h4>
                        <span class="text-muted d-block mb-2" id="pname">超级管理员</span>
                        <form action="" method="post" name="form1" class="mb-2 btn btn-sm btn-pill btn-outline-primary mr-2">
                            <%--                           <button type="button" class="mb-2 btn btn-sm btn-pill btn-outline-primary mr-2">--%>
<%--                                <input type="hidden" style="opacity: 0; width:10px" id="fileimguse" value="nam" name="name"/>--%>
                                <input type=""hidden="" name="name" value="njik">
                                <input type="file" style="opacity: 0; width:10px" id="fileimguse"/>
                            <i class="material-icons mr-1">person_add</i>Follow
                            <%--                           </button>--%>
                        </form>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item p-4"><strong
                                class="text-muted d-block mb-2">个人介绍</strong> <span id="uDescri">Lorem
									ipsum dolor sit amet consectetur adipisicing elit. Odio eaque,
									quidem, commodi soluta qui quae minima obcaecati quod dolorum
									sint alias, possimus illum assumenda eligendi cumque?</span></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-8">
                <div class="card card-small mb-4">
                    <div class="card-header border-bottom">
                        <h6 class="m-0">资料修改</h6>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item p-3">
                            <div class="row">
                                <div class="col">
                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <label for="feFirstName">会员编号</label> <input type="text"
                                                                                         class="form-control"
                                                                                         id="feFirstName"
                                                                                         placeholder="First Name"
                                                                                         value="Sierra">
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="feLastName">姓名</label> <input type="text"
                                                                                      class="form-control"
                                                                                      id="feLastName"
                                                                                      placeholder="Last Name"
                                                                                      value="Brooks">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <label for="feEmailAddress">Email</label> <input
                                                type="email" class="form-control" id="feEmailAddress"
                                                placeholder="Email" value="sierra@example.com">
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="fePassword">Password</label> <input
                                                type="password" class="form-control" id="fePassword"
                                                placeholder="Password">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="feInputAddress">Address</label> <input
                                            type="text" class="form-control" id="feInputAddress"
                                            placeholder="1234 Main St">
                                    </div>
                                    <div class="form-row">
                                        <!--<div class="form-group col-md-6">
                                                    <label for="feInputCity">City</label>
                                                    <input type="text" class="form-control" id="feInputCity"> </div>
                                                <div class="form-group col-md-4">
                                                    <label for="feInputState">State</label>
                                                    <select id="feInputState" class="form-control">
                                                        <option selected>Choose...</option>
                                                        <option>...</option>
                                                    </select>
                                                </div>-->
                                        <div class="form-group col-md-2">
                                            <label for="inputZip">组织编号</label> <input type="text"
                                                                                      class="form-control" id="g123id">
                                            <span id="g12450"></span>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-12">
                                            <label for="feDescription">介绍</label>
                                            <textarea class="form-control" name="feDescription" rows="5"
                                                      id="uDescri2"></textarea>
                                        </div>
                                    </div>
                                    <button class="btn btn-default" id="123456abc">修改</button>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- End Default Light Table -->
    </div>
</div>
<script type="text/javascript">
    $('#fileimguse').on('change', function () {
        var th = $(this);
        var filePath = $(this).val(), //获取到input的value，里面是文件的路径
            fileFormat = filePath.substring(filePath.lastIndexOf(".")).toLowerCase(),
            src = window.URL.createObjectURL(this.files[0]); //转成可以在本地预览的格式
        // 检查是否是图片
//		alert(filePath)
        if (!fileFormat.match(/.png|.jpg|.jpeg/)) {
            alert("上传错误,文件格式必须为：png/jpg/jpeg")
            return;
        } else {
            $('[name="imguser"]').attr("src", src);
            if (confirm("是否更换头像?")) {
                var f = $('[name="form1"]');
                var form = new FormData(f[0]);
                $.ajax({
                    url: "vote?src=modifyUserImg",
                    data: form,
                    processData: false,
                    type: "post",
                    contentType: false,
                    success: function (result) {
                        alert(result)
                    }

                });
                return false;
            } else {
                $('[name="imguser"]').attr("src", "images/user.png");
            }
        }
    })
</script>
</body>
</html>