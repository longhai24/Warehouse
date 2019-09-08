<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2019/5/31
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/an-skill-bar.css">
    <link rel="stylesheet" href="css/main.css">

</head>


<body>
<c:forEach var="a" items="${Votesum}">

<div class="container">
    <div id="skill">
        <div class="skillbar css">
            <span class="title"></i> ${a.name1}</span>
            <span class="percent">${a.po1}%</span>
            <div class="filled" data-width="${a.po1}%"></div>
        </div>
        <div class="skillbar js">
            <span class="title">${a.name2}%</span>
            <span class="percent">${a.po2}%</span>
            <div class="filled" data-width="${a.po2}%"></div>
        </div>
        <div class="skillbar php">
            <span class="title">${a.name3}</span>
            <span class="percent">${a.po3}%</span>
            <div class="filled" data-width="${a.po3}%"></div>
        </div>
        <div class="skillbar sass">
            <span class="title"></i> ${a.name4}</span>
            <span class="percent">${a.po4}%</span>
            <div class="filled" data-width="${a.po4}%"></div>
        </div>
    </div>
</div>
</c:forEach>
</body>
<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="js/an-skill-bar.js"></script>
<script src="js/main.js"></script>
</html>
