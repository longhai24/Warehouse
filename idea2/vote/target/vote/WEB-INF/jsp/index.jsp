<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Image Survey HTML Form by templatemo</title>
    <%--    <link rel="stylesheet" href="assets/css/bootstrap.min.css">--%>
    <%--    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">--%>
    <link rel="stylesheet" href="assets/css/ready.css">
    <link rel="stylesheet" href="assets/css/demo.css">
    <!-- load CSS -->
    <%--    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:400,600">--%>
    <!-- Google web font "Open Sans" -->
    <link rel="stylesheet" href="css/materialize.min.css">
    <!-- https://materializecss.com -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- https://getbootstrap.com/ -->
    <link rel="stylesheet" href="css/all.min.css">
    <!-- https://fontawesome.com/ -->
    <link rel="stylesheet" href="css/templatemo-style.css">
    <!-- Template Mo style -->

</head>

<body>
<div class="container">
    <div class="row" style="height: 80px">
        <div class="col-sm-12 col-md-7">
            <i class="far fa-comments fa-5x tm-site-icon"></i>
            <h1 class="tm-site-name">形象调查</h1>
        </div>
        <div class="col-sm-12 col-md-5 mt-md-0 mt-5">
            <div class="tm-site-header-right-col">
                <a href="Managing.html" class="btn btn-primary">联系我们</a>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-12">
            <div class="tm-parallax"></div>
        </div>
    </div>
    <div class="row">
        <div class="tm-intro">
            <div class="col-sm-12 col-md-8 mb-md-0 mb-4 tm-intro-left">
                <p class="mb-0">
                    投票是选举人使用自己选举权利的一种方式，有选举人将所要选的人的姓名写在票，或在印有候选人姓名的选票上做出标记，投入票箱。可以填写投票人自己的姓名也可以不写，不写则成为不记名投票。
                    投票在某种程度上反映了民意，对参与投票的人的行为具有一定的指导作用<a href="#">templatemo</a>Thank you.</p>
            </div>
            <div class="col-sm-12 col-md-4">
                <em>
                    <p class="tm-highlight">&ldquo;您的意见很重要&rdquo;</p>
                </em>
            </div>

        </div>
        <div class="col-12">
            <hr>
        </div>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h3>介绍:</h3>
        <div class="col-md-3">
            <div class="demo-icon">
                <div class="icon-preview"><i class="la la-paper-plane"></i></div>
                <div class="icon-class">${vp.vptrace}</div>
            </div>
        </div>
        <div class="col-12">
            <hr>
        </div>
    </div>

    <form action="vote?src=submitVote" method="post">
        <div class="row borderrow">
            <c:forEach items="${vp.listVote}" var="l" varStatus="i">
                <div class="col-12">
                    <h2 class="tm-question-header">编号:${i.count}</h2>
                    <input type="hidden" value="${l.vid}">
                    <h4>问题:${l.vissue}</h4>
                    <div class="tm-q-choice-container">
                            <%--                        A--%>
                        <c:if test="${l.voptionA != '' and l.voptionA != null}">
                            <label class="tm-q-choice">
                                <div class="mb-3">
                                    <input class="tm-radio-group-1 with-gap" name="${l.vid}" type="radio"
                                           value="${l.voptionA}"/>
                                    <span>${l.voptionA}</span>
                                </div>
                            </label>
                        </c:if>
                            <%--    B--%>
                        <c:if test="${l.voptionB != '' and l.voptionB != null}">
                            <label class="tm-q-choice">
                                <div class="mb-3">
                                    <input class="tm-radio-group-1 with-gap" name="${l.vid}" type="radio"
                                           value="${l.voptionB}"/>
                                    <span>${l.voptionB}</span>
                                </div>
                            </label>
                        </c:if>
                            <%--    C--%>
                        <c:if test="${l.voptionC != '' and l.voptionC != null}">
                            <label class="tm-q-choice">
                                <div class="mb-3">
                                    <input class="tm-radio-group-1 with-gap" name="${l.vid}" type="radio"
                                           value="${l.voptionC}"/>
                                    <span>${l.voptionC}</span>
                                </div>
                            </label>
                        </c:if>
                            <%--                        D--%>
                        <c:if test="${l.voptionD != '' and l.voptionD != null}">
                            <label class="tm-q-choice">
                                <div class="mb-3">
                                    <input class="tm-radio-group-1 with-gap" name="${l.vid}" type="radio"
                                           value="${l.voptionD}"/>
                                    <span>${l.voptionD}</span>
                                </div>
                            </label>
                        </c:if>
                            <%--                        E--%>
                        <c:if test="${l.voptionE != '' and l.voptionE != null}">
                            <label class="tm-q-choice">
                                <div class="mb-3">
                                    <input class="tm-radio-group-1 with-gap" name="${l.vid}" type="radio"
                                           value="${l.voptionE}"/>
                                    <span>${l.voptionE}</span>
                                </div>
                            </label>
                        </c:if>
                    </div>
                    <div></div>
                    <button class="btn btn-primary btn-sm indexsmcx" style="display: block;padding: 5px 10px">查询</button>
                </div>
                <!-- col-12 -->
            </c:forEach>
        </div> <!-- row -->
        <button class="btn btn-primary btn-lg" type="submit">提交</button>
    </form>
    <div class="row">
        <div class="col-12">
            <footer>
                <p class="text-center mb-3 tm-footer-text">天星科技 &copy; 2019 <a href="" target="_blank" title="">李棋</a>
                </p>
            </footer>
        </div>
    </div>
</div>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/materialize.min.js"></script>
<script>
    $(document).on("click",".indexsmcx",function(){
        var vid = $(this).parents(".col-12").find($('[type="hidden"]')).val();
        $(this).prev().load("vote?src=skip-jin&vid="+vid);
         return false;
     })
    // Parallax function
    // https://codepen.io/roborich/pen/wpAsm
    var background_image_parallax = function ($object, multiplier) {
        multiplier = typeof multiplier !== 'undefined' ? multiplier : 0.5;
        multiplier = 1 - multiplier;
        var $doc = $(document);
        $object.css({"background-attatchment": "fixed"});
        $(window).scroll(function () {
            var from_top = $doc.scrollTop(),
                bg_css = 'center ' + (multiplier * from_top - 200) + 'px';
            $object.css({"background-position": bg_css});
        });
    };

    /**
     * detect IE
     * returns version of IE or false, if browser is not Internet Explorer
     */
    function detectIE() {
        var ua = window.navigator.userAgent;

        var msie = ua.indexOf('MSIE ');
        if (msie > 0) {
            // IE 10 or older => return version number
            return parseInt(ua.substring(msie + 5, ua.indexOf('.', msie)), 10);
        }

        var trident = ua.indexOf('Trident/');
        if (trident > 0) {
            // IE 11 => return version number
            var rv = ua.indexOf('rv:');
            return parseInt(ua.substring(rv + 3, ua.indexOf('.', rv)), 10);
        }

        // var edge = ua.indexOf('Edge/');
        // if (edge > 0) {
        //     // Edge (IE 12+) => return version number
        //     return parseInt(ua.substring(edge + 5, ua.indexOf('.', edge)), 10);
        // }

        // other browser
        return false;
    }

    $(document).ready(function () {

        // Detect IE
        if (detectIE()) {
            alert('Please use the latest version of Chrome, Firefox, or Edge for best browsing experience.');
        }

        $('select').formSelect();
        // Parallax image background
        background_image_parallax($(".tm-parallax"), 0.40);

        // Darken image when its radio button is selected
        $(".tm-radio-group-1").click(function () {
            $('.tm-radio-group-1').parent().siblings("img").removeClass("darken");
            $(this).parent().siblings("img").addClass("darken");
        });

        $(".tm-radio-group-2").click(function () {
            $('.tm-radio-group-2').parent().siblings("img").removeClass("darken");
            $(this).parent().siblings("img").addClass("darken");
        });

        $(".tm-checkbox").click(function () {
            $(this).parent().siblings("img").toggleClass("darken");
        })
    });
</script>
</body>

</html>
