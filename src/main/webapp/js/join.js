
function checkLength(obj) {
    if (obj.value == "") {
        obj.classList.add('is-invalid')
        obj.classList.remove('is-valid')
    } else {
        obj.classList.add('is-valid')
        obj.classList.remove('is-invalid')
    }
}

function checkId(obj) {
    $.ajax({
        type: "post",
        url: "idcheck",
        data: {"id": $("#userid").val()},
        success: function (d) {
            answer = d.trim();
            if (answer == "yes") {
                obj.classList.add('is-valid');
                obj.classList.remove('is-invalid');

                alert("사용 가능한 아이디입니다.");
            } else {
                obj.classList.add('is-invalid')
                obj.classList.remove('is-valid')

                alert("사용 불가능한 아이디입니다.");
            }
        },
        error: function (e) {
            alert("에러:" + e);
        }
    })
}

var checkPwd = function(obj) {
    var pwdCheck = obj;
    if ($("#pwd").val() != $(pwdCheck).val()) {
        obj.classList.add('is-invalid');
        obj.classList.remove('is-valid');

        $(pwdCheck).

        alert("비밀번호가 일치하지 않습니다.");
    } else {
        obj.classList.add('is-valid');
        obj.classList.remove('is-invalid');
    }
}