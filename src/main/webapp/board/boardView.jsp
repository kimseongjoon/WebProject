<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/header.jsp"%>
<%--<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    &lt;%&ndash;<script>
        function del() {
            if (confirm("정말 삭제할까요?")) {
                location.href = "deletePro.jsp?num=" + <%=num%>;
            }
        }
    </script>&ndash;%&gt;
</head>
<body>--%>

<script>
    $(function () {
        $("#replyBtn").click(function () {
            if (${empty sessionScope.user}){
                alert("로그인해주세요");
                location.href = "/project/member/login";
            }
            else{
                $("#frm").submit();
            }
        })
    })
</script>
<h2>글 내용 보기</h2>
<form id="frm" method="get" action="replywrite">
    <input type="hidden" name="num" value="${board.num}">
    <input type="hidden" name="ref" value="${board.ref}">
    <input type="hidden" name="re_step" value="${board.re_step}">
    <input type="hidden" name="re_level" value="${board.re_level}">
</form>
<table border="1" cellspacing="0">
    <tr>
        <td>글번호</td>
        <td>${board.num}</td>
        <td>조회수</td>
        <td>${board.readcount}</td>
    </tr>
    <tr>
        <td>작성자</td>
        <td>${board.writer}</td>
        <td>작성일</td>
        <td>${board.reg_date}</td>
    </tr>
    <tr>
        <td>글제목</td>
        <td colspan="3">${board.subject}</td>
    </tr>
    <tr>
        <td>글내용</td>
        <td colspan="3">${board.content}</td>
    </tr>
    <tr>
        <td align="center" colspan="4">
            <c:if test="${(not empty sessionScope.user.userid) && (sessionScope.user.userid.equals(board.writer))}">
                <input type="button" value="글수정" onclick="location.href='update?num=${board.num}'"/>
                <input type="reset" value="글삭제" onclick="location.href='delete?num=${board.num}'"/>
            </c:if>
            <input type="button" value="답글쓰기" id="replyBtn" onclick="location.href='replywrite?num=${board.num}&ref=${board.ref}&re_step=${board.re_step}&re_level=${board.re_level}'"/>
            <input type="button" value="글목록" onclick="location.href='list'"/>
        </td>
    </tr>
</table>

<br><br><br><br>
<div align="center">
    <textarea rows="5" cols="5" id="msg"></textarea>
    <input type="button" value="댓글쓰기" id="commentBtn">
</div>
<div id="area">

</div>
<script>
    var init = function () {
        $.getJSON("commentList",
            {"bnum":${board.num}},
            function (result) {
                var htmlStr = "<table>"
                $.each(result.jarr, function (key, val) {
                    htmlStr += "<tr>";
                    htmlStr += "<td>" + val.msg + "</td>";
                    htmlStr += "<td>" + val.userid + "</td>";
                    htmlStr += "<td>" + val.regdate + "</td>";
                    htmlStr += "</tr>";
                });
                htmlStr += "</table>";

                $("#area").html(htmlStr);
            }
        );
    };

    $("#commentBtn").on("click", function () {
        $.ajax({
            type : "get",
            url : "commentWrite",
            data : {"comment" : $("#msg").val(), "bnum" : ${board.num}},
            success :function (resp) {
                if (resp.trim() == 1) {
                    alert("로그인하세요");
                    location.href = "../member/login.jsp";
                } else {
                    init();
                    alert("${sessionScope.user.userid}님 반갑습니다.")
                }
            },
            error :function (e) {
                alert("error:" + e);
            }
        })
    });

    init()
</script>
</body>
</html>