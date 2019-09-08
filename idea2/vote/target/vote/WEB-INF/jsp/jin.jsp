<%--
  Created by IntelliJ IDEA.
  User: 25191
  Date: 2019/5/31
  Time: 8:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <style type="text/css">
        .faslgda {
            background: #161616 url(pattern_40.gif) top left repeat;
            margin: 0;
            padding: 0;
            font: 12px normal Verdana, Arial, Helvetica, sans-serif;
            height: 100%;
            color:#fff;
        }

        * {margin: 0; padding: 0; outline: none;}

        img {border: none;}

        a {
            text-decoration:none;
            color:#00c6ff;
        }

        h1 {
            font: 4em normal Arial, Helvetica, sans-serif;
            padding: 20px;	margin: 0;
            text-align:center;
            color:#bbb;
        }

        h1 small{
            font: 0.2em normal  Arial, Helvetica, sans-serif;
            text-transform:uppercase; letter-spacing: 0.2em; line-height: 5em;
            display: block;
        }

        h2 {
            font: 2em normal Arial, Helvetica, sans-serif;
            padding-bottom:30px;
            color:#fff;
            display:block;
        }

        .container {
            width: 960px;
            margin: 0 auto;
            overflow: hidden;
        }

        .content{
            width:278px;
            margin:0;
            position:relative;
            float:left;
            font-size:12px;
            line-height:2em;
            padding:30px 0 30px;
        }
        .col { width:280px; }

        #skill {
            list-style:none;
            padding-top:30px;
        }

        #skill li {
            margin-bottom:70px;
            background:#000;
            height:5px;
            border-radius:3px;
            border-left:1px solid #111;
            border-top:1px solid #111;
            border-right:1px solid #333;
            border-bottom:1px solid #333;
        }

        #skill li em {
            position:relative;
            top:-30px;
        }

        .expand {
            height:1px;
            margin:2px 0;
            background:#2187e7;
            position:absolute;
            box-shadow:0px 0px 10px 1px rgba(0,198,255,0.4);
        }

        .html1       { width:${jin.a}%;  -moz-animation:html5 2s ease-out;       -webkit-animation:html5 2s ease-out;       }
        .html2        { width:${jin.b}%;  -moz-animation:css3 2s ease-out;        -webkit-animation:css3 2s ease-out;        }
        .html3      { width:${jin.c}%;  -moz-animation:jquery 2s ease-out;      -webkit-animation:jquery 2s ease-out;      }
        .html4   { width:${jin.d}%;  -moz-animation:photoshop 2s ease-out;   -webkit-animation:photoshop 2s ease-out;   }
        .html5 { width:${jin.e}%; -moz-animation:dreamweaver 2s ease-out; -webkit-animation:dreamweaver 2s ease-out; }

        @-moz-keyframes html5       { 0%  { width:0px;} 100%{ width:70%;}  }
        @-moz-keyframes css3        { 0%  { width:0px;} 100%{ width:90%;}  }
        @-moz-keyframes jquery      { 0%  { width:0px;} 100%{ width:50%;}  }
        @-moz-keyframes photoshop   { 0%  { width:0px;} 100%{ width:10%;}  }
        @-moz-keyframes dreamweaver { 0%  { width:0px;} 100%{ width:100%;} }

        @-webkit-keyframes html5       { 0%  { width:0px;} 100%{ width:70%;}  }
        @-webkit-keyframes css3        { 0%  { width:0px;} 100%{ width:90%;}  }
        @-webkit-keyframes jquery      { 0%  { width:0px;} 100%{ width:50%;}  }
        @-webkit-keyframes photoshop   { 0%  { width:0px;} 100%{ width:10%;}  }
        @-webkit-keyframes dreamweaver { 0%  { width:0px;} 100%{ width:100%;} }

    </style>
</head>
<body id="lokfmfadfna">
<%--<h1>CSS3个人技能进度条</h1>--%>
<div>
    <div class="content faslgda">
        <div class="col">
            <h2>My Skill</h2>
            <ul id="skill">
                <c:if test="${v.voptionA !=null}">
                    <li><span class="expand html1"></span><em>${v.voptionA}</em>${jin.a}%</li>
                </c:if>
                <c:if test="${v.voptionB !=null}">
                    <li><span class="expand html2"></span><em>${v.voptionB}</em>${jin.b}%</li>
                </c:if>
                <c:if test="${v.voptionC !=null}">
                    <li><span class="expand html3"></span><em>${v.voptionC}</em>${jin.c}%</li>
                </c:if>
                <c:if test="${v.voptionD !=null}">
                    <li><span class="expand html4"></span><em>${v.voptionD}</em>${jin.d}%</li>
                </c:if>
                <c:if test="${v.voptionE !=null}">
                    <li><span class="expand html5"></span><em>${v.voptionE}</em>${jin.e}%</li>
                </c:if>
            </ul>
        </div>
    </div>
</div>
<%--<div style="text-align:center;clear:both">--%>
</div>
</body>
</html>

