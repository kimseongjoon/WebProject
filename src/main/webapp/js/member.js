
$(function () {
    /*$("#send").click(function () {
        //
        // if ($("#name").val() == "") {
        //     alert("이름을 넣어주세요");
        //     $("#name").focus();
        //
        //     return false;
        // }
        // if ($("#userid").val() == "") {
        //     alert("아이디를 넣어주세요");
        //     $("#userid").focus();
        //
        //     return false;
        // }
        //
        // if ($("#pwd").val() == "") {
        //     alert("비밀번호를 입력하세요");
        //     $("#pwd").focus();
        //
        //     return false;
        // }
        // if ($("#pwd").val() != $("#pwd_check").val()) {
        //     alert("비밀번호가 일치하지 않습니다.");
        //     $("#pwd_check").focus();
        //
        //     return false;
        // }
        //
        // // if ($("#email").val() == "") {
        // //     alert("이메일을 넣어주세요");
        // //     $("#email").focus();
        // //
        // //     return false;
        // // }
        //
        // if (! ($("#phone").val().match(exp)) ) {
        //     alert("전화번호 양식이 아닙니다.");
        //     $("#phone").focus();
        //
        //     return false;
        // }

        $("#frm").submit();
    });*/

    $("#idCheckBtn").click(function () {
        window.open("idcheck", "", "width=500 height=300");
    })

    function del(userid, adminStr) {
        if (adminStr == "관리자") {
            alert("관리자는 삭제할 수 없습니다.");
        }
    }

    $("#userBtn").click(function () {
        $.ajax({
            type:"post",
            url:"idcheck",
            data:{"id":$("#id").val()},
            success:function (d) {
                alert();
                answer = d.trim();
                if (answer == "yes") {
                    alert("사용 가능한 아이디입니다.");

                    var id = $("#id").val();
                    $(opener.document).find("#userid").val(id);
                    self.close();
                } else {
                    alert("사용 불가능한 아이디입니다.");
                }
            },
            error:function (e) {
                alert("에러:" + e);
            }
        })
    })
})


function del(userid) {
    $.ajax({
        type    : "post",
        url     : "userdelete",
        data    : {"userid" : userid},
        success : function (data) {
            let d = JSON.parse(data);
            let htmlStr = "";
            $.each(d.jarr, function (key, val) {
                htmlStr += "<tr>";
                htmlStr += "<td>" + val.name + "</td>";
                htmlStr += "<td>" + val.userid + "</td>";
                htmlStr += "<td>" + val.phone + "</td>";
                htmlStr += "<td>" + val.email + "</td>";
                if (val.admin == 0) {
                    htmlStr += "<td>일반회원</td>";
                    htmlStr += "<td><a href=\"javascript:del('" + val.userid + "')\">삭제</td>";
                }
                else {
                    htmlStr += "<td>관리자</td>";
                    htmlStr += "<td></td>";
                }
                htmlStr += "</tr>";
            })
            $("#tbody").html(htmlStr);
            $("#cnt").text("전체회원수:" + d.count);

            alert("삭제완료");
        },
        error   : function () {
            alert("error : " + e);
        }
    })
}

