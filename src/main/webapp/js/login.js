$(function () {
    $("#loginBtn").click(function () {
        if ($("#userid").val() == "") {
            alert("아이디를 입력하세요");
            $("#userid").focus();
            return false;
        }

        if ($("#pwd").val() == "") {
            alert("비밀번호를 입력하세요");
            $("#pwd").focus();
            return false;
        }

        $.ajax({
            type    : "post",
            url     : "/project/member/login",
            data    : {"userid" : $("#userid").val(), "pwd" : $("#pwd").val()},
            success : function (data) {
                // alert(data);
                var d = data.trim();
                if (d == 0) {
                    alert("일반회원 로그인");
                    $(location).attr("href", "view");
                } else if (d == 1) {
                    alert("관리자 로그인");
                    $(location).attr("href", "list");
                } else if (d == -2) {
                    alert("비밀번호를 확인하세요");
                } else if (d == -1) {
                    alert("회원이 아닙니다. 회원가입하세요");
                }
            },
            error : function (e) {
                alert("error:" + e)
            }
        });
    });
})