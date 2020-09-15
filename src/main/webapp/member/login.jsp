<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/header.jsp"%>

<!-- Breadcrumb Section Begin -->
<div class="breacrumb-section">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb-text">
                    <a href="#"><i class="fa fa-home"></i> Home</a>
                    <span>Login</span>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Breadcrumb Form Section Begin -->

<!-- Register Section Begin -->
<div class="register-login-section spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 offset-lg-3">
                <div class="login-form">
                    <h2>Login</h2>
                    <form action="#">
                        <div class="group-input">
                            <label for="userid">User ID</label>
                            <input type="text" id="userid">
                        </div>
                        <div class="group-input">
                            <label for="pwd">Password</label>
                            <input type="text" id="pwd">
                        </div>
                        <div class="group-input gi-check">
                            <div class="gi-more">
                                <label for="save-pass">
                                    Save Password
                                    <input type="checkbox" id="save-pass">
                                    <span class="checkmark"></span>
                                </label>
                                <a href="#" class="forget-pass">Forget your Password</a>
                            </div>
                        </div>
                        <button type="button" class="site-btn login-btn" id="loginBtn">Sign In</button>
                    </form>
                    <div class="switch-login">
                        <a href="/project/member/join" class="or-login">Or Create An Account</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/project/js/login.js"></script>
<!-- Register Form Section End -->

<%@ include file="/include/footer.jsp"%>
