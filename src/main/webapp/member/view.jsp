<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/header.jsp"%>

${member.userid}님 반갑습니다. / <a href="logout">로그아웃</a>
<br><br>
<a href="../board/list.jsp">게시판으로</a>
<h3>회원정보변경 / <a href="userDelete.jsp">회원탈퇴</a></h3>
<form action="update" method="post">
<input type="hidden" name="userid" id="userid" value="${member.userid}">
<table>
    <tr>
        <td>이름</td>
        <td><input type="text" name="name" id="name" value="${member.name}" readonly></td>
    </tr>
    <tr>
        <td>비밀번호</td>
        <td><input type="text" name="pwd" id="pwd" value="${member.pwd}"></td>
    </tr>
    <tr>
        <td>이메일</td>
        <td><input type="text" name="email" id="email" value="${member.email}"></td>
    </tr>
    <tr>
        <td>전화번호</td>
        <td><input type="text" name="phone" id="phone" value="${member.phone}"></td>
    </tr>
    <tr>
        <td colspan="2">
            등급
            <label class="form-check-label" for="radio1">
                일반회원 <input type="radio" class="form-check-input" id="radio1" name="admin" value="0">
            </label>
            <label class="form-check-label" for="radio2">
                관리자 <input type="radio" class="form-check-input" id="radio2" name="admin" value="1">
            </label>
            <script>
                if (${member.admin} == 0)
                {
                    $("input:radio[value='0']").prop("checked", true);
                }
                else
                {
                    $("input:radio[value='1']").prop("checked", true);
                }
            </script>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <button>수정</button>
            <input type="reset" value="취소">
        </td>
    </tr>
</table>
</form>
</body>
</html>
