<%--

<!DOCTYPE html>
<html>
<head>
    <title>Title</title>

</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <!-- Brand/logo -->
    <a class="navbar-brand" href="#">Logo</a>
    <!-- Links -->
    <ul class="navbar-nav">
        <c:choose>
            <c:when test="${empty sessionScope.user}">
                <li class="nav-item">
                    <a class="nav-link" href="/project/member/login">로그인</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/project/member/join">회원가입</a>
                </li>
            </c:when>
            <c:otherwise>
                <li class="nav-item">
                    ${sessionScope.user.userid}님 반갑습니다
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/project/member/logout">로그아웃</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/project/product/addProduct.jsp">상품등록</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">회원변경</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/project/member/delete">회원탈퇴</a>
                </li>
            </c:otherwise>
        </c:choose>
        <li class="nav-item">
            <a class="nav-link" href="/project/board/list">게시판</a>
        </li><li class="nav-item">

        <li class="nav-item">
            <a class="nav-link" href="/project/product/productList">상품목록</a>
        </li><li class="nav-item">
    </li>
    </ul>
</nav>
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Fashi Template">
    <meta name="keywords" content="Fashi, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Fashi | Template</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="/project/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="/project/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="/project/css/themify-icons.css" type="text/css">
    <link rel="stylesheet" href="/project/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="/project/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="/project/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="/project/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="/project/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="/project/css/style.css" type="text/css">


<%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <script src="/project/js/member.js"></script>

    <script src="/project/js/jquery-3.3.1.min.js"></script>
    <script src="/project/js/jquery.slicknav.js"></script>
    <script src="/project/js/bootstrap.min.js"></script>
    <script src="/project/js/jquery-ui.min.js"></script>
    <script src="/project/js/jquery.countdown.min.js"></script>
    <script src="/project/js/jquery.nice-select.min.js"></script>
    <script src="/project/js/jquery.zoom.min.js"></script>
    <script src="/project/js/jquery.dd.min.js"></script>
    <script src="/project/js/owl.carousel.min.js"></script>
    <script src="/project/js/main.js"></script>

</head>

<body>
<c:set value="${pageContext.request.contextPath}" var="path"/>
<c:set value="${pageContext.request.contextPath}/board" var="boardpath"/>

<!-- Page Preloder -->
<div id="preloder">
    <div class="loader"></div>
</div>

<!-- Header Section Begin -->
<header class="header-section">
    <div class="header-top">
        <div class="container">
            <div class="ht-left">
                <div class="mail-service">
                    <i class=" fa fa-envelope"></i>
                    hello.colorlib@gmail.com
                </div>
                <div class="phone-service">
                    <i class=" fa fa-phone"></i>
                    +65 11.188.888
                </div>
            </div>
            <div class="ht-right">
                <c:choose>
                    <c:when test="${empty sessionScope.user}">
                        <a href="/project/member/login" class="login-panel"><i class="fa fa-user"></i>Login</a>
                    </c:when>
                    <c:otherwise>
                        <a href="/project/member/logout" class="login-panel"><i class="fa fa-user"></i>Logout</a>
                    </c:otherwise>
                </c:choose>
                <div class="lan-selector">
                    <select class="language_drop" name="countries" id="countries" style="width:300px;">
                        <option value='yt' data-image="/project/img/flag-1.jpg" data-imagecss="flag yt"
                                data-title="English">English</option>
                        <option value='yu' data-image="/project/img/flag-2.jpg" data-imagecss="flag yu"
                                data-title="Bangladesh">German </option>
                    </select>
                </div>
                <div class="top-social">
                    <a href="#"><i class="ti-facebook"></i></a>
                    <a href="#"><i class="ti-twitter-alt"></i></a>
                    <a href="#"><i class="ti-linkedin"></i></a>
                    <a href="#"><i class="ti-pinterest"></i></a>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="inner-header">
            <div class="row">
                <div class="col-lg-2 col-md-2">
                    <div class="logo">
                        <a href="/project/index.jsp">
                            <img src="/project/img/logo.png" alt="">
                        </a>
                    </div>
                </div>
                <div class="col-lg-7 col-md-7">
                    <div class="advanced-search">
                        <button type="button" class="category-btn">All Categories</button>
                        <form action="#" class="input-group">
                            <input type="text" placeholder="What do you need?">
                            <button type="button"><i class="ti-search"></i></button>
                        </form>
                    </div>
                </div>
                <div class="col-lg-3 text-right col-md-3">
                    <ul class="nav-right">
                        <li class="heart-icon"><a href="#">
                            <i class="icon_heart_alt"></i>
                            <span>1</span>
                        </a>
                        </li>
                        <li class="cart-icon"><a href="#">
                            <i class="icon_bag_alt"></i>
                            <span>3</span>
                        </a>
                            <div class="cart-hover">
                                <div class="select-items">
                                    <table>
                                        <tbody>
                                        <tr>
                                            <td class="si-pic"><img src="/project/img/select-product-1.jpg" alt=""></td>
                                            <td class="si-text">
                                                <div class="product-selected">
                                                    <p>$60.00 x 1</p>
                                                    <h6>Kabino Bedside Table</h6>
                                                </div>
                                            </td>
                                            <td class="si-close">
                                                <i class="ti-close"></i>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="si-pic"><img src="/project/img/select-product-2.jpg" alt=""></td>
                                            <td class="si-text">
                                                <div class="product-selected">
                                                    <p>$60.00 x 1</p>
                                                    <h6>Kabino Bedside Table</h6>
                                                </div>
                                            </td>
                                            <td class="si-close">
                                                <i class="ti-close"></i>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="select-total">
                                    <span>total:</span>
                                    <h5>$120.00</h5>
                                </div>
                                <div class="select-button">
                                    <a href="#" class="primary-btn view-card">VIEW CARD</a>
                                    <a href="#" class="primary-btn checkout-btn">CHECK OUT</a>
                                </div>
                            </div>
                        </li>
                        <li class="cart-price">$150.00</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="nav-item">
        <div class="container">
            <div class="row">
                <div class="nav-depart">
                    <div class="depart-btn">
                        <i class="ti-menu"></i>
                        <span>All departments</span>
                        <ul class="depart-hover">
                            <li class="active"><a href="#">Women’s Clothing</a></li>
                            <li><a href="#">Men’s Clothing</a></li>
                            <li><a href="#">Underwear</a></li>
                            <li><a href="#">Kid's Clothing</a></li>
                            <li><a href="#">Brand Fashion</a></li>
                            <li><a href="#">Accessories/Shoes</a></li>
                            <li><a href="#">Luxury Brands</a></li>
                            <li><a href="#">Brand Outdoor Apparel</a></li>
                        </ul>
                    </div>
                </div>
                <nav class="nav-menu mobile-menu">
                    <ul>
                        <li><a href="/project/index.jsp">Home</a></li>
                        <li><a href="/project/product/productList">Shop</a></li>
                        <li><a href="#">Collection</a>
                            <ul class="dropdown">
                                <li><a href="#">Men's</a></li>
                                <li><a href="#">Women's</a></li>
                                <li><a href="#">Kid's</a></li>
                            </ul>
                        </li>
                        <%--                    <li><a href="./blog.html">Blog</a></li>--%>
                        <li><a href="/project/board/list">Notice</a></li>
                        <li><a href="./contact.html">Contact</a></li>
                        <li><a href="#">Pages</a>
                            <ul class="dropdown">
                                <li><a href="./blog-details.html">Blog Details</a></li>
                                <li><a href="./shopping-cart.html">Shopping Cart</a></li>
                                <li><a href="./check-out.html">Checkout</a></li>
                                <li><a href="./faq.html">Faq</a></li>
                                <li><a href="./register.html">Register</a></li>
                                <li><a href="./login.html">Login</a></li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
            <div id="mobile-menu-wrap"></div>
        </div>
    </div>
</header>
<!-- Header End -->