<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/header.jsp"%>

<script>
    $(function() {
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
                        // $(location).attr("href", "");
                    } else if (d == 1) {
                        alert("관리자 로그인");
                        $(location).attr("href", "")
                    } else if (d == 2) {
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
</script>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
            <div class="card card-signin my-5">
                <div class="card-body">
                    <h5 class="card-title text-center">Sign In</h5>
                    <form class="form-signin">
                        <div class="form-label-group">
                            <input type="text" id="userid" class="form-control" placeholder="ID" required autofocus>
                            <label for="userid">ID</label>
                        </div>

                        <div class="form-label-group">
                            <input type="password" id="pwd" class="form-control" placeholder="Password" required>
                            <label for="pwd">Password</label>
                        </div>

                        <div class="custom-control custom-checkbox mb-3">
                            <input type="checkbox" class="custom-control-input" id="customCheck1">
                            <label class="custom-control-label" for="customCheck1">Remember password</label>
                        </div>
                        <button class="btn btn-lg btn-primary btn-block text-uppercase" type="button" id="loginBtn">Login</button>
<%--                        <hr class="my-4">--%>
<%--                        <button class="btn btn-lg btn-google btn-block text-uppercase" type="submit"><i class="fab fa-google mr-2"></i> Sign in with Google</button>--%>
<%--                        <button class="btn btn-lg btn-facebook btn-block text-uppercase" type="submit"><i class="fab fa-facebook-f mr-2"></i> Sign in with Facebook</button>--%>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

<%@ include file="/include/footer.jsp"%>
