//var name = $("#name"); //用户名
//var pname = $("#pname"); //权限名字
//var uDescri = $("#uDescri"); // 个人介绍
//
var l = window.sessionStorage.getItem("user");
console.log(l)
var user = eval('(' + l + ')');
$("#name").val(user.uname);
$("#uDescri").val(user.uDescri);
$("#feFirstName").val(user.uid); // 会员编号
$("#feLastName").val(user.uname); //姓名
$("#feEmailAddress").val(user.uEmail); //邮箱
$("#fePassword").val(user.upwd); //密码
$("#uDescri").text(user.uDescri); //介绍
$("#uDescri2").text(user.uDescri); //介绍
$("#feInputAddress").val(user.uAddress); //地址
$("#g123id").val(user.g.gid); //组织码
//修改事件
$("#123456abc").click(function () {
    var yue =  $("#g12450").text();
    if("请核对组织码!" == yue){
        alert("请填写正确")
        return false;
    }
    var uid = $("#feFirstName").val(); // 会员编号
    var uname = $("#feLastName").val(); //姓名
    var uemail = $("#feEmailAddress").val(); //邮箱
    var upwd = $("#fePassword").val(); //密码
    var uDescri2 = $("#uDescri2").val(); //介绍
    var uAddress = $("#feInputAddress").val(); //地址
    var gid = $("#g123id").val(); //组织码
    var user = {'uid': uid,'uname': uname,'uemail': uemail,'upwd': upwd,'uDescri': uDescri2,'uAddress': uAddress,'gid': gid};
    $.ajax({
        type: "post",
        url: "vote?src=modifyUser",
        data: {'user':JSON.stringify(user)},
        dataType: "text",
        success: function (result) {
            alert(result)
            if("ok" == result){
                alert("修改成功")
            }
        }
    });
})
//验证组织码
$("#g123id").blur(function () {
    var gid = $("#g123id").val(); //组织码
    $.ajax({
        type:"post",
        url:"vote?src=findGroup",
        data:{'gid':gid},
        dataType: "text",
        success: function (result) {
            if("ok" == result){
                $("#g12450").html("可以更改");
            }else{
                $("#g12450").html("请核对组织码!");
            }
        }
    });
});

