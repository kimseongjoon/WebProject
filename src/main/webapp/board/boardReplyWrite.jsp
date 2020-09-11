<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../include/header.jsp" %>

<div class="container mt-3">

    <form action="replywrite" method="post" id="frm">
        <input type="hidden" name="writer" value=${sessionScope.user.userid}>
        <input type="hidden" name="num" value="${bean.num}">
        <input type="hidden" name="ref" value="${bean.ref}">
        <input type="hidden" name="re_step" value="${bean.re_step}">
        <input type="hidden" name="re_level" value="${bean.re_level}">


<%--        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" placeholder="Enter name" name="writer">
        </div>--%>
        <div class="form-group">
            <label for="subject">Subject:</label>
            <input type="text" class="form-control" id="subject" placeholder="Enter subject" name="subject" value="[답변]">
        </div>
        <div class="form-group">
            <label for="eamil">Eamil:</label>
            <input type="text" class="form-control" id="eamil" placeholder="Enter eamil" name="eamil" value="${sessionScope.user.email}">
        </div>
        <div class="form-group">
            <label for="passwd">Password:</label>
            <input type="password" class="form-control" id="passwd" placeholder="Enter PWD" name="passwd">
        </div>
        <div class="form-group">
            <label for="content">Comment:</label>
            <textarea class="form-control" rows="5" id="content" name="content"></textarea>
        </div>
        <button  type="submit"  class="btn btn-primary">답글쓰기</button>
    </form>
</div>
<%@ include file="../include/footer.jsp" %>