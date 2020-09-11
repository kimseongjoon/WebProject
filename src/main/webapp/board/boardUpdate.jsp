<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/header.jsp"%>
<h3>글 수정하기</h3>
<form action="update" method="post">
    <input type="hidden" name="num" value="${board.num}">
    <table border="1" cellspacing="0">
        <tr>
            <td align="right" colspan="2"><a href="list.jsp">글목록</a></td>
        </tr>
        <tr>
            <td>이름</td>
            <td>${board.writer}</td>
        </tr>
        <tr>
            <td>제목</td>
            <td><input type="text" name="subject" value="${board.subject}>"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email" value="${board.email}"></td>
        </tr>
        <tr>
            <td>내용</td>
            <td><textarea cols="50" rows="50" name="content">${board.content}</textarea></td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td><input type="password" name="passwd"></td>
        </tr>
        <tr>
            <td align="center" colspan="2">

                <input type="submit" value="글수정"/>
                <input type="reset" value="다시작성"/>
                <input type="button" value="목록보기" onclick="location.href='list.jsp'"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
