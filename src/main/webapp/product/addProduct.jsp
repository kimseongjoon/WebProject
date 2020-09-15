<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-09-01(001)
  Time: 오후 1:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/header.jsp"%>

<h3>상품 등록</h3>
<form action="addProduct" method="post" enctype="multipart/form-data">
    <table border="1" cellspacing="0">
        <tr>
            <td>상품 코드</td>
            <td><input type="text" name="code" id="code"></td>
        </tr>
        <tr>
            <td>상품명</td>
            <td><input type="text" name="name" id="name"></td>
        </tr>
        <tr>
            <td>가격</td>
            <td><input type="text" name="price" id="price"></td>
        </tr>
        <tr>
            <td>상세정보</td>
            <td><input type="text" name="detail" id="detail"></td>
        </tr>
        <tr>
            <td>제조사</td>
            <td><input type="text" name="manufacturer" id="manufacturer"></td>
        </tr>
        <tr>
            <td>분류</td>
            <td><input type="text" name="category" id="category"></td>
        </tr>
        <tr>
            <td>재고 수</td>
            <td><input type="text" name="stock" id="stock"></td>
        </tr>
        <tr>
            <td>상태</td>
            <td>
                <input type="radio" name="condition" id="condition1" value="0">
                <label for="condition1">신규 제품</label>&nbsp;
                <input type="radio" name="condition" id="condition2" value="1">
                <label for="condition2">중고 제품</label>&nbsp;
                <input type="radio" name="condition" id="condition3" value="2">
                <label for="condition3">재생 제품</label>
            </td>
        </tr>
        <tr>
            <td>이미지</td>
            <td><input type="file" name="filename" id="filename"></td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <input type="submit" value="등록"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
