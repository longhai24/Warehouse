<%-- Created by IntelliJ IDEA. User: apple Date: 2019/5/28 Time: 22:26 To change this template use File | Settings | File Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head><title>Title</title>
    <link rel="stylesheet" href="css/page.css" />
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
    <link href="css/show.css" />
</head>
<body>
<div class="left">
    <div class="bigTitle">投票管理系统</div>
    <div class="lines">
        <div onclick="pageClick(this)" class="active"><img src="img/icon-1.png"/>投票</div>
        <div onclick="pageClick(this)"><img src="img/icon-2.png"/>管理投票</div>
        <div onclick="pageClick(this)"><a onclick=""></a><img src="img/icon-3.png"/>查看投票信息</div>
    </div>
</div>
<div class="top">
    <div class="leftTiyle" id="flTitle">投票管理</div>
    <div class="thisUser">当前用户：${user.userName}<a href="VoteSubAction?method=toaddVote">新增投票</a></div>
</div>
<div class="content" style="">
    <div><table>
        <thead>
        <tr>
            <td>投票标题</td>
            <td>投票简介</td>
            <td>封面图片</td>
            <td>创建时间</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table></div>
</div>
<div class="content1" style="display: none;">管理投票</div>
<div class="content2" style="display: none;"></div>
</body>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    $.ajax({
        url:"VoteSubAction",
        data:{
            method:"SelVote"
        },
        dataType:"json",
        type:"post",
        success:function (data) {
                tab(data)
        }
    })

    $(document).on("click", ".lasPage", function(e) {
        $.ajax({
            url:"VoteSubAction",
            data: {
                method: "lastPage"
            },
            dataType:"json",
            type:"post",
            success:function (data) {
                tab(data)
            }
        })
        return false;
    })
    $(document).on("click", ".firPage", function(e) {
        $.ajax({
            url:"VoteSubAction",
            data:{
                method:"firPage"
            },
            dataType:"json",
            type:"post",
            success:function (data) {
                tab(data)
            }
        })
        return false;
    })

    $(document).on("click", ".previousPage", function(e) {
        $.ajax({
            url:"VoteSubAction",
            data:{
                method:"DownPage"
            },
            dataType:"json",
            type:"post",
            success:function (data) {
                tab(data);
            }
        })
        return false;
    })
    $(document).on("click", ".tovote", function(e) {
        var v = $(this).parent().parent().attr("id");
        window.location.href="VoteSubAction?method=toBeganVote&v="+v
        return false;
    })
    $(document).on("click", ".nextPage", function(e) {
        $.ajax({
            url:"VoteSubAction",
            data:{
                method:"NextPage"
            },
            dataType:"json",
            type:"post",
            success:function (data) {
                tab(data);
            }
        })
        return false;
    })
    	function tab(data) {
    			$(".content tbody tr").remove();
    			for (var i = 0; i < data.length; i++) {
    				var a = data[i];
    				var tr = $("<tr id="+a.voteid+"></tr>");
    				var td1 = $("<td>" + a.votetitle + "</td>");
    				var td2 = $("<td>" + a.voteparticulars + "</td>");
    				var td3 = $("<td><img src="+a.votepic+" width=50px height='50px'></td>");
    				var td4 = $("<td>" + a.votedate + "</td>");
    				var td5 = $("<td><a href='' class=tovote>投票</a> <a href='' class=delvote>删除</a> </td>");
    				tr.append(td1).append(td2).append(td3).append(td4).append(td5)
    				$(".content tbody").append(tr)
    			}
    			var atr = $("<tr></tr>");
    			var atd1 = $("<td><a href='' class=firPage>首页</a>|<a href='' class=previousPage>上一页</a>|<a href=''class=nextPage>下一页</a>|<a href=''class=lasPage>尾页</a></td>")
    			atr.append(atd1);
    			$(".content tbody").append(atr)
    		}
    $(document).on("click", ".delvote", function(e) {
        var v = $(this).parent().parent().attr("id");
        $.ajax({
            url:"VoteSubAction",
            data:{
                method:"delVote",
                did:v
            },
            type:"post",
            success:function (data) {
                if (data=="a"){
                    window.location.href="VoteSubAction?method=login"
                }
            }
        })
        return false;
    })
</script>
</html>
