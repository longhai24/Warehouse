//加载操作
$(".gxiugai").hide();
$(".liqitpxg").hide();
$("#vstarttime").change(function () {
    var a = $("#vstarttime").val()
    var arr = a.split("-");
    var starttime = new Date(arr[0], arr[1] - 1, arr[2]);
    var m = starttime.getTime();
    var myDate = new Date();
    var n = myDate.getTime();
    if (m + 86400000 < n) {
        alert("请选择正确时间")
        $(this).val("")
    }
})

//截至日期
$("#vdeadline").change(function () {
    var op = $("#vstarttime").val() //开始时间
    var po = $("#vdeadline").val() //截至时间
    duibi(op, po)
})

//日期比较
function duibi(a, b) {
    var arr = a.split("-");
    var starttime = new Date(arr[0], arr[1], arr[2]);
    var starttimes = starttime.getTime();

    var arrs = b.split("-");
    var lktime = new Date(arrs[0], arrs[1], arrs[2]);
    var lktimes = lktime.getTime();
    if ((lktimes - starttimes) / 86400000 > 30) {
        alert("日期相差不能大于30天")
        $("#vdeadline").val("")
    }
}

//桶分页
$(".vppage").click(function () {
    var num = $(this).attr("aria-label");
    if (num == '0') {
        return false;
    }
    $.ajax({
        url: "vote?src=findVpPage",
        data: {'num': num},
        dataType: "json",
        type: "post",
        success: function (result) {
            $("#vptd").children().remove();
            $(".prvepage").attr("aria-label", result.prePage)
            $(".nextpage").attr("aria-label", result.nextPage)
            $.each(result.list, function (i, j) {
                var tr = $("<tr>");
                var th = $('<th>').html(j.vpid);
                var td1 = $('<td>').html(j.vpname);
                var td2 = $('<td>').html(j.vptrace);
                var td3 = $('<td>');
                if (j.vstatus == 0) {
                    td3.html("运行");
                } else {
                    td3.html("截至");
                }
                var td4 = $('<td><span class="badge badge-primary gliqixg">修改</span></td>');
                var td5 = $('<td><span class="badge badge-primary gliqixr">查阅</span></td>');
                tr.append(th).append(td1).append(td2).append(td3).append(td4).append(td5)
                $("#vptd").append(tr)
            })
        }
    })
})
//分页颜色
$(".pagination > li").click(function () {
    $(this).parents(".pagination").find("li").removeClass("active")
    $(this).addClass("active");
})
//修改桶
$("#gsubmit").click(function () {
    var yes = $("#yes").is(":checked"); //判断是否选中同意条款
    var gname = $("#gname").val();
    var gref = $("#gref").val();
    var vpid = $("#gid").val();
    var action = 0;
    var vstarttime = $("#vstarttime").val(); // 开始时间
    var vdeadline = $("#vdeadline").val(); //截至时间
    alert(vdeadline)
    if (gname == "" || gref == "" || vstarttime == "" || vdeadline == "") {
        alert("请填写完整.")
        return false;
    }
    if (yes) {
        action = 1;
    }
    var vp = {
        'vpaction': action,
        'vpname': gname,
        'vptrace': gref,
        "vstarttime": vstarttime,
        "vdeadline": vdeadline,
        'vpid': vpid
    }
    $.ajax({
        url: "vote?src=modifyVp",
        data: {'vp': JSON.stringify(vp)},
        type: "post",
        dataType: "text",
        success: function (result) {
            if ("ok" == result) {
                alert(result)
            }
        }
    });

})
//桶点击修改渲染
$(document).on("click", ".gliqixg", function () {
    var thi = $(this);
    var gid = $(this).parents("tr").find("th").text();
    $.ajax({
        type: "post",
        dataType: "json",
        data: {'vpid': gid},
        url: "vote?src=findVotePail",
        success: function (result) {
            $("#gname").val(result.vpname);
            $("#gref").val(result.vptrace);
            $("#gid").val(result.vpid);
            alert(result.vstarttime)
            $("#vstarttime").val("2019-12-12")
            $("#vdeadline").val(result.vdeadline);
            var chk = document.getElementById('yes');
            if (result.vpaction != '0') {
                chk.checked = true;
            } else {
                chk.checked = false;
            }
            $(".gxiugai").show();
        }
    })
})
//投票修改渲染
$(document).on("click", ".voteupdate", function () {
    var vid = $(this).parents("tr").find("td:eq(0)").text();
    $(".liqitpxg").show();
    $.ajax({
        type: "post",
        url: "vote?src=findVote",
        data: {'vid': vid},
        dataType: "json",
        success: function (result) {
            $("#liqitpxg").show();
            $("#vissue").val(result.vissue);
            $("#gid").val(vid);
            var ygh = $(".voptionA")
            $(ygh[0]).val(result.voptionA);
            $(ygh[1]).val(result.voptionB);
            $(ygh[2]).val(result.voptionC);
            $(ygh[3]).val(result.voptionD);
            $(ygh[4]).val(result.voptionE);
            $(".voptionA").each(function (i,j) {
                if("" ==$(this).val() || null == $(this).val()){
                    $(this).parents(".xuanliqi").remove();
                }
            })
        }
    });
})
var findvpid;
//桶点击查看渲染投票
$(document).on("click", ".gliqixr", function () {
    var gid = $(this).parents("tr").find("th").text();
    findvpid = gid;
    $.ajax({
        type: "post",
        url: "vote?src=findVotes",
        data: {'vpid': gid},
        dataType: "json",
        success: function (result) {
            $("#votd").children().remove();
            $(".voprevpage").attr("aria-label", result.prePage)
            $(".vonextpage").attr("aria-label", result.nextPage)
            $.each(result.list, function (i, j) {
                var tr = $("<tr>");
                var td1 = $("<td>").html(j.vid);
                var td2 = $("<td>").html(j.vissue);
                var td3 = $("<td>").html(j.voptionA);
                var td4 = $("<td>").html(j.voptionB);
                var td5 = $('<td><span class=\"badge badge-primary votedelete\">删除</span></td>');
                var td6 = $("<td><span class=\"badge badge-primary voteupdate\">修改</span></td>")
                tr.append(td1).append(td2).append(td3).append(td4).append(td5).append(td6)
                $("#votd").append(tr);
            })
        }
    });
})

//修改按鈕
$("#wan").click(function () {
    var inp = $(".voptionA");
    var option = []; //问题选项
    var name = $("#vissue").val(); //问题
    var vid = $("#gid").val() // 投票id
    $(".voptionA").each(function(i, j) {
        option[i] = $(this).val();
    })
    var voptionA = option[0]; //选项1
    var voptionB= option[1];//选项2
    var voptionC= option[2];//选项3
    var voptionD= option[3];//选项4
    var voptionE= option[4];//选项5
    if(option[0] == "" || option[1] == "" || name == "" || vstarttime == "" || vdeadline == "") {
        alert("请填写完整")
        return false;
    }
    var str = {"vid": vid,"vissue": name,"voptionA": voptionA,"voptionB": voptionB,"voptionC": voptionC,"voptionD": voptionD,"voptionE": voptionE}
    $.ajax({
        url: "vote?src=midifyVote",
        data: {'str':JSON.stringify(str)},
        type: "post",
        dataType: "text",
        success: function(result) {
            if("ok" == result){
                alert("修改完成")
                $(".liqitpxg").hide();//添加完成隐藏添加div
            }
        }
    });
})
//投票分页
$(".mnbjj").click(function () {
    var num = $(this).attr("aria-label");
    if (num == '0') {
        return false;
    }
    $.ajax({
        type: "post",
        url: "vote?src=findVotes",
        data: {'vpid': findvpid,'num':num},
        dataType: "json",
        success: function (result) {
            $("#votd").children().remove();
            $(".voprevpage").attr("aria-label", result.prePage)
            $(".vonextpage").attr("aria-label", result.nextPage)
            $.each(result.list, function (i, j) {
                var tr = $("<tr>");
                var td1 = $("<td>").html(j.vid);
                var td2 = $("<td>").html(j.vissue);
                var td3 = $("<td>").html(j.voptionA);
                var td4 = $("<td>").html(j.voptionB);
                var td5 = $('<td><span class=\"badge badge-primary votedelete\">删除</span></td>');
                var td6 = $("<td><span class=\"badge badge-primary voteupdate\">修改</span></td>")
                tr.append(td1).append(td2).append(td3).append(td4).append(td5).append(td6)
                $("#votd").append(tr);
            })
        }
    });
})
//选项添加 +
$(document).on("click", ".jia", function() {
    var xuan = $(".xuanliqi");
    if(xuan.length >= 5) {
        alert("最多添5个选项")
        return false;
    }
    var xuan = $('<div class="form-group xuanliqi"><label for="pillInput">请填写选项</label><input type="text" class="form-control input-pill voptionA"  placeholder=" 列:天晴"><span class="badge badge-default jia">+</span><span class="badge badge-default jian">-</span></div>')
    $(this).parents(".xuanliqi").after(xuan)
})
//选项删除 -
$(document).on("click", ".jian", function() {
    var xuan = $(".xuanliqi");
    if(xuan.length >= 3) {
        $(this).parents(".xuanliqi").remove();
    } else {
        alert("至少添加两个选项")
    }
})