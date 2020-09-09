<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="/project/js/member.js"></script>
    <script src="/project/js/join.js"></script>
    <link type="text/css" rel="stylesheet" href="/project/css/join.css">
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
                    <a class="nav-link" href="#">회원변경</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/project/member/delete">회원탈퇴</a>
                </li>
            </c:otherwise>
        </c:choose>
        <li class="nav-item">
            <a class="nav-link" href="#">게시판</a>
        </li>
    </ul>
</nav>
