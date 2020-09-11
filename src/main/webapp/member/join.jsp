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
                    <h4 class="card-title text-center" style="margin-bottom: 0.4em">Register</h4>
                    <p class="card-title text-center" style="font-size: small" >Fields marked with'*' are required.
                    </p>

                    <form class="form-signin" action="join" method="post" id="frm">
                        <div class="form-label-group">
                            <input type="text" id="userid" name="userid" class="form-control" placeholder="ID" oninput="checkId(this)" required autofocus>
                            <label for="userid">ID(*)</label>
                            <div class="valid-feedback" style="display: block">&nbsp</div>
                            <div class="invalid-feedback"></div>
                        </div>

                        <div class="form-label-group">
                            <input type="password" id="pwd" name="pwd" class="form-control" placeholder="Password" oninput="checkPw(this)" required>
                            <label for="pwd">Password(*)</label>
                            <div class="valid-feedback" style="display: block">&nbsp</div>
                            <div class="invalid-feedback"></div>
                        </div>

                        <div class="form-label-group">
                            <input type="password" id="pwd_check" name="pwd_check" class="form-control" placeholder="Re-enter Password"  oninput="checkRePw(this)" required>
                            <label for="pwd_check">Re-enter Password(*)</label>
                            <div class="valid-feedback" style="display: block">&nbsp</div>
                            <div class="invalid-feedback"></div>
                        </div>

                        <div class="form-label-group">
                            <input type="text" id="name" name="name" class="form-control" placeholder="Your name" oninput="checkName(this)" required>
                            <label for="name">Name(*)</label>
                            <div class="valid-feedback" style="display: block">&nbsp</div>
                            <div class="invalid-feedback"></div>
                        </div>

                        <div class="row">
                            <div class="form-label-group">
                                <input type="text" id="zipcode" name="zipcode" class="form-control" placeholder="ZIP code" oninput="checkZipcode(this)" required>
                                <label for="zipcode">ZIP code</label>
                                <div class="valid-feedback" style="display: block">&nbsp</div>
                                <div class="invalid-feedback"></div>
                            </div>

                            <div class="form-label-group" style="align-self: end">
                                <button class="btn btn-lg btn-primary btn-block text-uppercase" type="button" onclick="zipfinder()">Search</button>

                            </div>

                            <div class="form-label-group">
                                <input type="text" id="addr" name="addr" class="form-control" placeholder="Your Address" oninput="checkAddr(this)" required>
                                <label for="addr">Address</label>
                                <div class="valid-feedback" style="display: block">&nbsp</div>
                                <div class="invalid-feedback"></div>
                            </div>

                            <div class="form-label-group">
                                <input type="text" id="detailAddr" name="detailAddr" class="form-control" placeholder="Your Address" oninput="checkDetailAddr(this)" required>
                                <label for="detailAddr">Detail address</label>
                                <div class="valid-feedback" style="display: block">&nbsp</div>
                                <div class="invalid-feedback"></div>
                            </div>
                        </div>

                        <div class="form-label-group">
                            <input type="email" id="email" name="email" class="form-control" placeholder="Email address" oninput="checkEmail(this)" required>
                            <label for="email">Email address</label>
                            <div class="valid-feedback" style="display: block">&nbsp</div>
                            <div class="invalid-feedback"></div>
                        </div>

                        <div class="form-label-group">
                            <input type="tel" id="phone" name="phone" class="form-control" oninput="checkPhone(this)" placeholder="Phone number" required>
                            <label for="phone">Phone number</label>
                            <div class="valid-feedback" style="display: block">&nbsp</div>
                            <div class="invalid-feedback"></div>
                        </div>

                        <div class="custom-control custom-checkbox mb-3">
                            <input type="checkbox" class="custom-control-input" id="adminCheck" name="admin" value="1">
                            <label class="custom-control-label" for="adminCheck">Check if you are an administrator</label>
                        </div>
                        <button class="btn btn-lg btn-primary btn-block text-uppercase" id="send" type="button">Join</button>
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

