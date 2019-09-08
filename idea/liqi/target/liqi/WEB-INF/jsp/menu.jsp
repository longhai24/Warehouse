<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
'
<%@page isELIgnored="false" %>
<html>
<head>


    <title>Title</title></head>
<body>
帖子标题<input type="text" class="tit"><input type="button" class="but" value="提交">
<table>
    <thead>
    <tr>
        <td>标题</td>
        <td>内容摘要</td>
        <td>作者</td>
        <td>发布时间</td>
        <td>操作</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="a">
        <tr>

            <td>${a.title}</td>
            <td>${a.summary}</td>
            <td>${a.author}</td>
            <td>${a.createdate}</td>
            <td><a href="">查看回复</a><a href="">删除</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td><a href="" class="up">上一页</a><a href="" class="down">下一页</a></td>
    </tr>
    </tbody>
</table>
</body>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">

    $("a").click(function () {
        return false;
    })
    $(".but").click(function () {
        var tit = $(".tit").val();
        alert(tit)
        $.ajax({
            url: "idea_test",
            data: {
                method: "selSome",
                tit: tit
            },
            dataType: "json",
            type: "post",
            success: function (data) {
               alert(data)

            }

        })
    })
    $(".down").click(function () {
        $.ajax({
            url:"idea_test",
            data: {
                method:"down"
            },
            dataType:"json",
            type:"post",
            success:function (data) {

            }
        })
    })
     function tbl (data) {
         for (var i = 0; i <data.length ; i++) {
                alert(i.summary)
         }
    }
</script>
</html>
