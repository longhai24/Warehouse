<%--
  Created by IntelliJ IDEA.
  User: 25191
  Date: 2019/5/30
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head lang="en">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>投票</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min02.css">
    <link rel="stylesheet" type="text/css" href="css/style02.css">
</head>
<body>
<div class="ct-pageWrapper">
    <main>
        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <div class="widget">
                        <h2 class="widget-header">计票本</h2>
                        <div class="ct-cart"></div>
                    </div>
                </div>
                <div class="col-md-9">
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="ct-product">
                                <div class="image"><img src="images/product-01.jpg" alt=""></div>
                                <div class="inner"><a href="#" class="btn btn-motive ct-product-button"><i
                                        class="fa fa-shopping-cart"></i></a>
                                    <h2 class="ct-product-title">孙略茗</h2>
                                    <p class="ct-product-description">A very delicious macaroons ...</p><span
                                            class="ct-product-price">@185</span>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="ct-product">
                                <div class="image"><img src="images/product-02.jpg" alt=""></div>
                                <div class="inner"><a href="#" class="btn btn-motive ct-product-button"><i
                                        class="fa fa-shopping-cart"></i></a>
                                    <h2 class="ct-product-title">Cherry Straws</h2>
                                    <p class="ct-product-description">A very delicious macaroons ...</p><span
                                            class="ct-product-price">@34.99</span>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="ct-product">
                                <div class="image"><img src="images/product-03.jpg" alt=""></div>
                                <div class="inner"><a href="#" class="btn btn-motive ct-product-button"><i
                                        class="fa fa-shopping-cart"></i></a>
                                    <h2 class="ct-product-title">Coffee Macaroons</h2>
                                    <p class="ct-product-description">A very delicious macaroons ...</p><span
                                            class="ct-product-price">@59.99</span>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="ct-product">
                                <div class="image"><img src="images/product-04.jpg" alt=""></div>
                                <div class="inner"><a href="#" class="btn btn-motive ct-product-button"><i
                                        class="fa fa-shopping-cart"></i></a>
                                    <h2 class="ct-product-title">Finetti ones</h2>
                                    <p class="ct-product-description">A very delicious macaroons ...</p><span
                                            class="ct-product-price">@9.99</span>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="ct-product">
                                <div class="image"><img src="images/product-05.jpg" alt=""></div>
                                <div class="inner"><a href="#" class="btn btn-motive ct-product-button"><i
                                        class="fa fa-shopping-cart"></i></a>
                                    <h2 class="ct-product-title">Minty duo</h2>
                                    <p class="ct-product-description">A very delicious macaroons ...</p><span
                                            class="ct-product-price">@3.99</span>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="ct-product">
                                <div class="image"><img src="images/product-06.jpg" alt=""></div>
                                <div class="inner"><a href="#" class="btn btn-motive ct-product-button"><i
                                        class="fa fa-shopping-cart"></i></a>
                                    <h2 class="ct-product-title">Pistachio</h2>
                                    <p class="ct-product-description">A very delicious macaroons ...</p><span
                                            class="ct-product-price">@13.99</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>

    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/shop.min.js"></script>
    <script>
        var vpid = 1;
        $('body').ctshop({
            currency: '@',
            paypal: {
                // currency_code: 'EUR'
            }
        });
    </script>
</div>
</body>
</html>
