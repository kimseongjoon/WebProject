<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-09-01(001)
  Time: 오후 1:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/header.jsp"%>

<h3>글쓰기</h3>
<form action="write" method="post">
<%--    <input type="hidden" name="num" value=<%=num%>>
    <input type="hidden" name="ref" value=<%=ref%>>
    <input type="hidden" name="re_step" value=<%=re_step%>>
    <input type="hidden" name="re_level" value=<%=re_level%>>--%>
    <input type="hidden" name="writer" id="writer" value="${sessionScope.user.userid}">

    <table border="1" cellspacing="0">
        <tr>
            <td align="right" colspan="2"><a href="list.jsp">글목록</a></td>
        </tr>
        <tr>
            <td>제목</td>
            <td>
                <input type="text" name="subject" id="subject">
            </td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email" id="email"></td>
        </tr>
        <tr>
            <td>내용</td>
            <td><textarea cols="50" rows="50" name="content" id="content"></textarea></td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td><input type="password" name="passwd" id="passwd"></td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <input type="submit" value="글쓰기"/>
                <input type="reset" value="다시작성"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
