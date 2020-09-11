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
<div class="container">
    <%--    <h2>게시글 목록(<%=count%>)</h2>--%>
    <div align="right" style="margin-right: 20px" class="d-flex justify-content-between mt-3">
        <%--<%
            if (userid != null) {
        %>
        <a href="../member/memberView.jsp"><%=userid%></a>님 반갑습니다. /
        &lt;%&ndash;        <a href="../member/logout.jsp">로그아웃</a>&ndash;%&gt;
        <a href="/Gradle___org_example___Member_Project_1_0_SNAPSHOT_war__exploded_/member/logout.jsp">로그아웃</a>
        <a href="writeForm.jsp">글쓰기</a>
        <%
            }
        %>--%>
        <h3> 게시글리스트(<span id="cntSpan">${count}</span>) </h3>
        <c:if test="${not empty sessionScope.user}">
            <a href="write">
                <button type="button" class="btn btn-secondary">글쓰기</button>
            </a>
        </c:if>
    </div>
    <br>
    <br>
    <table class="table table-hover">
        <thead class="thead-dark">
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

    <ul class="pagination">
        <c:if test="${startPage > blockPage}">
        <li class="page-item"><a class="page-link" href="list?pageNum=${startPage - 1}">이전</a></li>
        </c:if>
        <c:forEach begin="${startPage}" end="${endPage}" var="i">
            <c:choose>
                <c:when test="${i == currentPage}">
                    <li class="page-item active"><a class="page-link" href="list?pageNum=${i}">${i}&nbsp;</a></li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a class="page-link" href="list?pageNum=${i}">${i}&nbsp;</a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:if test="${endPage < totPage}">
            <li class="page-item"><a class="page-link" href="list?pageNum=${endPage + 1}">다음</a></li>
        </c:if>
    </ul>
    <form action="list.jsp" name="search" method="get">
        <td align="center">
            <select name="field" size="1">
                <option value="subject">제 목
                <option value="writer">작성자
            </select>
            <input type="text" size="16" name="word">
            <input type="submit" name="찾기">
        </td>
    </form>
    <%--<div align="center">
        <%
            /*
                        int currentPage = Integer.parseInt(pageNum); pageNum가 NULL이면 1
                        int pageSize = 5; // 한 화면에 보여지는 컬럼 수
                        int startRow = ((currentPage - 1) * pageSize) + 1;
                        int endRow = currentPage * pageSize;*/
            if (count > 0) {    // 43 / 8        + (43 % 8==0? +0: +1)
                int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
                int pageBlock = 3; //
                int startPage = (int) ((currentPage - 1) / pageBlock) * pageBlock + 1;
                int endPage = startPage + pageBlock - 1;

                if (endPage > pageCount) {
                    endPage = pageCount;
                }

                if (startPage > pageBlock) {
        %>
        &lt;%&ndash;                    <a href="list.jsp?pageNum=<%=startPage - pageBlock%>&field=<%=field%>&word=<%=word%>">[이전]</a>&ndash;%&gt;
        <a href="list.jsp?pageNum=<%=startPage - 1%>&field=<%=field%>&word=<%=word%>">[이전]</a>
        <%
            }

            for (int i = startPage; i <= endPage; i++) {
                if (i == currentPage) {
        %>
        [<%=i%>]
        <%
        }
        else {
        %>
        <a href="list.jsp?pageNum=<%=i%>&field=<%=field%>&word=<%=word%>"><%=i%></a>
        <%
                }
            }

            if (endPage < pageCount) {
        %>
        &lt;%&ndash;                    <a href="list.jsp?pageNum=<%=startPage + pageBlock%>&field=<%=field%>&word=<%=word%>">[다음]</a>&ndash;%&gt;
        <a href="list.jsp?pageNum=<%=endPage + 1%>&field=<%=field%>&word=<%=word%>">[다음]</a>
        <%
                }
            }
        %>
    </div>--%>
</div>
</body>
</html>
