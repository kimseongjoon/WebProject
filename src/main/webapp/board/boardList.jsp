<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--  <%
      request.setCharacterEncoding("utf-8");

      String pageNum = request.getParameter("pageNum");
      if (pageNum == null) {
          pageNum = "1";
      }

      String field = "", word = "";
      if (request.getParameter("word") != null) {
          word = request.getParameter("word");
          field = request.getParameter("field");
      }

      int currentPage = Integer.parseInt(pageNum);
      int pageSize = 5; // 한 화면에 보여지는 페이지 수
      int startRow = ((currentPage - 1) * pageSize) + 1;
      int endRow = currentPage * pageSize;

      BoardDAO dao = BoardDAO.getInstance();
      ArrayList<BoardDTO> arr = dao.boardList(field, word, startRow, endRow);
      int count = dao.boardCount(field, word);
      //             23
      int number = count - (currentPage - 1) * pageSize; // 1번 페이지 -> count  2번 페이지 - > count - 5
      String userid = (String) session.getAttribute("userid");
  %>--%>
<%@ include file="/include/header.jsp" %>

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

<div class="container spad">
    <div class="row">
        <div class="offset-lg-1 col-lg-10 offset-xl-0 col-xl-12">
            <h2>Notice</h2>
            <br>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>글내용</th>
                    <th>조회수</th>
                    <th>작성일</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="bd" varStatus="st">
                    <tr>
                        <td align="right">${rowNo-st.index}</td>
                        <td><a href="detail?num=${bd.num}">${bd.subject}</a></td>
                        <td>${bd.writer}</td>
                        <td>${bd.content}</td>
                        <td align="right">${bd.readcount}</td>
                        <td>${bd.reg_date}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <ul class="pagination justify-content-center">
                <c:if test="${startPage > blockPage}">
                    <li class="page-item"><a class="page-link" href="list?pageNum=${startPage - 1}">이전</a></li>
                </c:if>
                <c:forEach begin="${startPage}" end="${endPage}" var="i">
                    <c:choose>
                        <c:when test="${i == currentPage}">
                            <li class="page-item active"><a class="page-link" style="background-color: #e7ab3c; border-color: #e7ab3c" href="list?pageNum=${i}">${i}&nbsp;</a></li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item"><a class="page-link" style="color: #e7ab3c" href="list?pageNum=${i}">${i}&nbsp;</a></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:if test="${endPage < totPage}">
                    <li class="page-item"><a class="page-link" href="list?pageNum=${endPage + 1}">다음</a></li>
                </c:if>
            </ul>
            <div align="right">
                <form action="list.jsp" name="search" method="get">
                    <td align="center">
                        <select name="field" size="1">
                            <option value="subject">제 목
                            <option value="writer">작성자
                        </select>
                        <input type="text" size="16" name="word">
                        <input type="submit" value="검색">
                    </td>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
