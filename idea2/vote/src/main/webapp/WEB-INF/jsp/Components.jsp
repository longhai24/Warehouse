<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>Home</title>
    <!--<link href='https://fonts.useso.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>-->
    <link rel="stylesheet" href="css/reset01.css">
    <!-- CSS reset -->
    <link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
    <link rel="stylesheet" href="css/style01.css">
    <link rel="stylesheet" href="css/klkll.css">
    <link rel="stylesheet" href="css/ddfd.css">
    <!-- Resource style -->
    <script src="js/modernizr.js"></script>
    <!-- Modernizr -->
</head>

<body>
<div class="content">
    <header class="cd-main-header animate-search">
        <nav class="cd-main-nav-wrapper">
            <a class="cd-search-trigger cd-text-replace">Search</a>

            <ul class="cd-main-nav">
                <li>
                    <a href="#0">李</a>
                </li>
                <li>
                    <a href="#0">棋</a>
                </li>
                <li>
                    <a href="#0">投</a>
                </li>
                <li>
                    <a href="#0">票</a>
                </li>
            </ul>
            <!-- .cd-main-nav -->
        </nav>
        <!-- .cd-main-nav-wrapper -->

        <a href="#0" class="cd-nav-trigger cd-text-replace">Menu<span></span></a>
    </header>

    <main class="cd-main-content">
        <!-- your content here -->
        <div class="content-center">
            <!-- <h1>Advanced Search Form</h1> -->
            <header class="htmleaf-header">
                <div id="resultBox"></div>
                <div id="paging">
                    <div class="first">首页</div>
                    <div class="prev">上一页</div>
                    <ul class="list"></ul>
                    <div class="go">
                        <input type="text" placeholder="Goto">
                        <button>跳转</button>
                    </div>
                    <div class="next">下一页</div>
                    <div class="last">末页</div>
                </div>
            </header>
        </div>
    </main>

    <div id="search" class="cd-main-search">
        <form method="post">
            <input type="search" name="name" placeholder="输入查询的名称">

            <div class="cd-select">
                <span>IN</span>
                <select name="term">
                    <option value="0">全部</option>
                    <option value="1">组织</option>
                </select>
                <span class="selected-value">条件</span>
            </div>
        </form>

        <div class="cd-search-suggestions">
            <div class="news">
                <h3>News</h3>
                <ul>
                    <li>
                        <a class="image-wrapper" href="#0"><img src="img/placeholder.png" alt="News image"></a>
                        <h4><a class="cd-nowrap" href="#0">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</a>
                        </h4>
                        <time datetime="2016-01-12">Feb 03, 2016</time>
                    </li>

                    <li>
                        <a class="image-wrapper" href="#0"><img src="img/placeholder.png" alt="News image"></a>
                        <h4><a class="cd-nowrap" href="#0">Incidunt voluptatem adipisci voluptates fugit beatae culpa
                            eum,
                            distinctio, assumenda est ad</a></h4>
                        <time datetime="2016-01-12">Jan 28, 2016</time>
                    </li>

                    <li>
                        <a class="image-wrapper" href="#0"><img src="img/placeholder.png" alt="News image"></a>
                        <h4><a class="cd-nowrap" href="#0">Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                            Iusto,
                            esse.</a></h4>
                        <time datetime="2016-01-12">Jan 12, 2016</time>
                    </li>
                </ul>
            </div>
            <!-- .news -->

            <div class="quick-links">
                <h3>Quick Links</h3>
                <ul>
                    <li>
                        <a href="#0">Find a store</a>
                    </li>
                    <li>
                        <a href="#0">Accessories</a>
                    </li>
                    <li>
                        <a href="#0">Warranty info</a>
                    </li>
                    <li>
                        <a href="#0">Support</a>
                    </li>
                    <li>
                        <a href="#0">Contact us</a>
                    </li>
                </ul>
            </div>
            <!-- .quick-links -->
        </div>
        <!-- .cd-search-suggestions -->

        <a href="#0" class="close cd-text-replace">Close Form</a>
    </div>
    <!-- .cd-main-search -->
    <div class="cd-cover-layer"></div>
    <!-- cover main content when search form is open -->
    <script type="text/javascript">
        console.log(${findTermVps});
        var data = {
            "count": ${sun},
            // "start": 1,
            // "total": 4,
            "books":
                ${findTermVps}
        };
    </script>
    <script src="js/jquery-2.1.1.min.js" type="text/javascript"></script>
    <script src="js/main.js"></script>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <%--    <script type="text/javascript" src="js/data.js"></script>--%>
    <script type="text/javascript" src='js/paging.js'></script>
    <!--		 Resource jQuery-->
</div>
</body>
</html>
