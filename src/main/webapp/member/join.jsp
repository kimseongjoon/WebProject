<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/header.jsp"%>

<div class="container">
    <div class="row">
        <div class="col-lg-10 col-xl-9 mx-auto">
            <div class="card card-signin flex-row my-5">
<%--                <div class="card-img-left d-none d-md-flex">--%>
<%--                    <!-- Background image for card set in CSS! -->--%>
<%--                </div>--%>
                <div class="card-body">
                    <h5 class="card-title text-center" style="margin-bottom: 1em">Register</h5>
                    <p class="card-title text-center" style="font-size: small" >Fields marked with'*' are required.
                    </p>
                    <form class="form-signin" action="join" id="frm">
                        <div class="form-label-group">
                            <input type="text" id="name" name="name" class="form-control" placeholder="Your name" required autofocus>
                            <label for="name">Name(*)</label>
                        </div>

                        <div class="form-label-group">
                            <input type="text" id="userid" name="userid" class="form-control" placeholder="ID" required autofocus>
                            <label for="userid">ID(*)</label>
                        </div>

                        <div class="form-label-group">
                            <input type="password" id="pwd" name="pwd" class="form-control" placeholder="Password" required>
                            <label for="pwd">Password(*)</label>
                        </div>

                        <div class="form-label-group">
                            <input type="password" id="pwd_check" name="pwd_check" class="form-control" placeholder="Re-enter Password" required>
                            <label for="pwd_check">Re-enter Password(*)</label>
                        </div>

                        <div class="form-label-group">
                            <input type="email" id="email" name="email" class="form-control" placeholder="Email address">
                            <label for="email">Email address</label>
                        </div>

                        <div class="form-label-group">
                            <input type="text" id="phone" name="phone" class="form-control" placeholder="Phone number">
                            <label for="phone">Phone number</label>
                        </div>

                        <div class="custom-control custom-checkbox mb-3">
                            <input type="checkbox" class="custom-control-input" id="customCheck1">
                            <label class="custom-control-label" for="customCheck1">Remember password</label>
                        </div>
                        <button class="btn btn-lg btn-primary btn-block text-uppercase" type="button" id="send">Join</button>
<%--                        <hr class="my-4">--%>
<%--                        <button class="btn btn-lg btn-google btn-block text-uppercase" type="submit"><i class="fab fa-google mr-2"></i> Sign in with Google</button>--%>
<%--                        <button class="btn btn-lg btn-facebook btn-block text-uppercase" type="submit"><i class="fab fa-facebook-f mr-2"></i> Sign in with Facebook</button>--%>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<%@ include file="/include/footer.jsp"%>

