<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/include/header.jsp" %>

<div align="right">
    <a href="view">${adminid}</a>관리자님 반갑습니다.
    <a href="logout">로그아웃</a>
    <span id="cnt">전체회원수:${count}</span>
</div>
<table border="1" cellpadding="0" cellspacing="0">
    <thead>
    <tr>
        <th>이름</th>
        <th>아이디</th>
        <th>전화번호</th>
        <th>이메일</th>
        <th>구분</th>
        <th>삭제</th>
    </tr>
    </thead>
    <tbody id="tbody">

    <c:forEach items="${members}" var="member">
        <tr>
            <td>${member.name}</td>
            <td>${member.userid}</td>
            <td>${member.phone}</td>
            <td>${member.email}</td>
            <td>
                <c:choose>
                    <c:when test="${member.admin == 0}">
                        <c:set var="adminStr" value="일반회원"/>
                        ${adminStr}
                        </td>
                        <td><a href="delete?${member.userid}">삭제</a></td>
                    </c:when>
                    <c:otherwise>
                        <c:set var="adminStr" value="관리자"/>
                        ${adminStr}
                        </td>
                        <td></td>
                    </c:otherwise>
                </c:choose>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
