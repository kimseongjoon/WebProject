

var jQueryScript = document.createElement('script');
jQueryScript.setAttribute('src','https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js');
document.head.appendChild(jQueryScript);

var exp = /^[0-9]{3}-[0-9]{4}-[0-9]{4}$/

$(function () {
    $("#send").click(function (event) {
        if ($("#frm")[0].checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
        } else {
            $("#frm").submit();
        }
    });
})

function checkId(obj) {
    let idCheck = obj;

    if (obj.value == "") {
        obj.classList.add('is-invalid')
        obj.classList.remove('is-valid')

        $(idCheck).siblings(".valid-feedback").css("display", "none");
        $(idCheck).siblings(".invalid-feedback").text("ID를 입력하세요.");
    } else {
        $.ajax({
            type: "post",
            url: "idcheck",
            data: {"id": $("#userid").val()},
            success: function (d) {
                answer = d.trim();
                if (answer == "yes") {
                    obj.classList.add('is-valid');
                    obj.classList.remove('is-invalid');

                    $(idCheck).siblings(".valid-feedback").css("display", "block");
                    $(idCheck).siblings(".valid-feedback").html("&nbsp");
                } else {
                    obj.classList.add('is-invalid');
                    obj.classList.remove('is-valid');

                    $(idCheck).siblings(".valid-feedback").css("display", "none");
                    // $(idCheck).siblings(".invalid-feedback").contents()[0].textContent = "사용 불가능한 아이디입니다.";
                    $(idCheck).siblings(".invalid-feedback").text("이미 사용중인 아이디입니다.");
                }
            },
            error: function (e) {
                alert("에러:" + e);
            }
        });
    }
}

function checkPw(obj) {
    let pwCheck = obj;

    if (obj.value == "") {
        obj.classList.add('is-invalid')
        obj.classList.remove('is-valid')

        $(pwCheck).siblings(".valid-feedback").css("display", "none");
        $(pwCheck).siblings(".invalid-feedback").text("비밀번호를 입력하세요.");
    } else {
        obj.classList.add('is-valid')
        obj.classList.remove('is-invalid')

        $(pwCheck).siblings(".valid-feedback").css("display", "block");
        $(pwCheck).siblings(".valid-feedback").html("&nbsp");
    }
}

function checkRePw(obj) {
    let rePwCheck = obj;

    if ($("#pwd").val() != $(rePwCheck).val()) {
        obj.classList.add('is-invalid');
        obj.classList.remove('is-valid');

        $(rePwCheck).siblings(".valid-feedback").css("display", "none");
        $(rePwCheck).siblings(".invalid-feedback").text("비밀번호가 일치하지 않습니다.");
    } else {
        obj.classList.add('is-valid');
        obj.classList.remove('is-invalid');

        $(rePwCheck).siblings(".valid-feedback").css("display", "block");
        $(rePwCheck).siblings(".valid-feedback").html("&nbsp");
    }
}

function checkName(obj) {
    let nameCheck = obj;

    if (obj.value == "") {
        obj.classList.add('is-invalid')
        obj.classList.remove('is-valid')

        $(nameCheck).siblings(".valid-feedback").css("display", "none");
        $(nameCheck).siblings(".invalid-feedback").text("이름을 입력하세요.");
    } else {
        obj.classList.add('is-valid')
        obj.classList.remove('is-invalid')
        $(nameCheck).siblings(".valid-feedback").css("display", "block");
        $(nameCheck).siblings(".valid-feedback").html("&nbsp");
    }
}

function checkZipcode(obj) {
    let zipCheck = obj;

    if (obj.value == "") {
        obj.classList.add('is-invalid')
        obj.classList.remove('is-valid')

        $(zipCheck).siblings(".valid-feedback").css("display", "none");
        $(zipCheck).siblings(".invalid-feedback").text("이름을 입력하세요.");
    } else {
        obj.classList.add('is-valid')
        obj.classList.remove('is-invalid')
        $(zipCheck).siblings(".valid-feedback").css("display", "block");
        $(zipCheck).siblings(".valid-feedback").html("&nbsp");
    }
}

function checkEmail(obj) {
    let emailCheck = obj;

    if (!obj.checkValidity()) {
        obj.classList.add('is-invalid');
        obj.classList.remove('is-valid');

        $(emailCheck).siblings(".valid-feedback").css("display", "none");
        $(emailCheck).siblings(".invalid-feedback").text(obj.validationMessage);
    } else {
        obj.classList.add('is-valid');
        obj.classList.remove('is-invalid');

        $(emailCheck).siblings(".valid-feedback").css("display", "block");
        $(emailCheck).siblings(".valid-feedback").html("&nbsp");
    }
}



function checkPhone(obj) {
    let phoneCheck = obj;

/*    if (!obj.checkValidity()) {
        obj.classList.add('is-invalid');
        obj.classList.remove('is-valid');

        $(phoneCheck).siblings(".invalid-feedback").text(obj.validationMessage);
    } else {
        obj.classList.add('is-valid');
        obj.classList.remove('is-invalid');
    }*/



    if (obj.value == "") {
        obj.classList.add('is-invalid')
        obj.classList.remove('is-valid')

        $(phoneCheck).siblings(".valid-feedback").css("display", "none");
        $(phoneCheck).siblings(".invalid-feedback").text("전화번호를 입력하세요.");
    } else {
        if (! ($(phoneCheck).val().match(exp)) ) {
            obj.classList.add('is-invalid')
            obj.classList.remove('is-valid')

            $(phoneCheck).siblings(".valid-feedback").css("display", "none");
            $(phoneCheck).siblings(".invalid-feedback").text("전화번호 양식이 아닙니다 ex) 000-0000-0000");
        }
        else {
            obj.classList.add('is-valid')
            obj.classList.remove('is-invalid')

            $(phoneCheck).siblings(".valid-feedback").css("display", "block");
            $(phoneCheck).siblings(".valid-feedback").html("&nbsp");
        }
    }
}

/*function zipfinder() {
    window.open("zipCheck.jsp", "", "width=700 height=400");
}*/


function zipfinder() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                //document.getElementById("sample6_extraAddress").value = extraAddr;

            } else {
                //document.getElementById("sample6_extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('zipcode').value = data.zonecode;
            document.getElementById("addr").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("detailAddr").focus();
        }
    }).open();
}

