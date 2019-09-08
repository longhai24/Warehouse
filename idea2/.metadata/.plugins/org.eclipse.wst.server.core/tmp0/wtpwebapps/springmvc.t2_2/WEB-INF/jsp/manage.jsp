<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理页面</title>
<style type="text/css">
      ul li{
      list-style: none;
      }
      .rightDiv{
      width: 800px;
      height: 400px;
      border: 1px solid red;
      padding:50px;
      position: absolute;
      top:0;
      left: 150px;
      }
</style>
</head>
<body>
<h2>论文管理系统</h2>
<h3>欢迎你:<span style="color: green;">${ USER.username}</span>&nbsp;<a href="http://localhost:8080/springmvc.t2_2/liqi/outUser" id="exit">注销</a></h3>
     <div style="position: relative;">
         <ul>
         <li>
                            功能列表
          <div class="rightDiv">
              <h2>${USER.username}</h2> 
              <h3>欢迎来到论文管理系统</h3>                          
         </div> 
         </li>
         <li>
         <a href="">用户管理</a>
         <div class="rightDiv">
                           
         </div> 
         </li>
         <li>
         <a href="managePaper?currentPage=1&RD=2">论文管理</a>
          <div class="rightDiv">
                           当前位置:论文管理页
          <form action="managePaper?currentPage=1&RD=${RD }" method="post">
         <label>论文主题:</label> <input type="text" name="title" value="${paramPaper.title }">
         <label>论文类型:</label> 
         <select name="cid">
         <option value="">--请选择--
         <c:forEach items="${CODE_LIST }" var="c">
         <option value="${c.id }"<c:if test="${paramPaper.cid==c.id }">selected='selected'</c:if> />${c.codetypename}
         </c:forEach>
         </select>
         <input type="submit" value="查询"><a href="toAddPaper">添加论文</a>
         </form>
          
          <table>
          <thead>
          <th>主题</th>
          <th>作者</th>
          <th>类型</th>
          <th>发表时间</th>
          <th>修改时间</th>
          <th>操作</th>
          </thead>
          <tbody>
          <c:forEach items="${PAGE.list }" var="p">
          <tr>
          <td>${p.title }</td>
          <td>${p.cuname}</td>
          <td>${p.codetypename }</td>
          <td><fmt:formatDate  value="${p.creationdate}" pattern="yyyy年MM月dd日HH点mm分ss秒"/> </td>
          <td><fmt:formatDate value="${p.modifydate}" pattern="yyyy年MM月dd日HH点mm分ss秒"/> </td>
          <td><a href="toModify?id=${p.id }">修改</a><a href="removePaper?id=${p.id }">删除</a> </td>
          
          </tr>
          </c:forEach>
          </tbody>
          </table>
          <h3>共${PAGE.total }条记录&nbsp; ${PAGE.pageNum }/${PAGE.pages }页</h3>
          <a class="nextPage" href="managePaper?currentPage=${PAGE.hasNextPage?PAGE.nextPage:PAGE.pages}&RD=${RD}">下一页</a><a class="lastPage" href="managePaper?currentPage=${PAGE.pages}&RD=${RD}">末页</a>
          <form id="f2" action=""  method="post">
          <input type="hidden" name="title" value="${paramPaper.title }">
          <input type="hidden" name="cid" value="${paramPaper.cid }">
          <h3>跳转至 <input type="text"   class="goPage">页&nbsp;&nbsp;&nbsp;<input type="submit" value="go" id="go"> </h3>
         </form>
         </div> 
         </li>
         <li>
         <a href="">公共代码</a>
          <div class="rightDiv">
                           
         </div> 
         </li>
         <li>
         <a href="">退出系统</a>
           <div class="rightDiv">
                           
         </div> 
         </li>
         </ul>
     </div>
</body>
<script type="text/javascript" src="../static/jquery-1.12.4.js"></script>
<script type="text/javascript">
        $(".rightDiv:not(:eq(${RD}))").hide();
        //action="managePaper?currentPage=1&RD=2";
        $(".nextPage,.lastPage").click(function(){
        	$("form").attr("action",$(this).attr("href"));
        	$("form").submit();
        	return false;
        });
        $("#go").click(function(){
        	goPage=$(".goPage").val();
        	if(goPage.trim()==""){
        		alert("请填写页码");
        		return false;
        	}else if(isNaN(goPage)){
        		alert("请填写数字");
        		return false;
        	}
        	goPage=goPage<1?1:goPage;
        	goPage=goPage>"${PAGE.pages}"?"${PAGE.pages}":goPage;
        	$("#f2").attr("action","managePaper?currentPage="+goPage+"&RD=${RD }");
        	$("#f2").submit();
        });
</script>
</html>