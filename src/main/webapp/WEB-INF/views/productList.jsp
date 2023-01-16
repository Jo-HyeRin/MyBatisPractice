<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="layout/header.jsp" %>

        <div class="container">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>상품명</th>
                        <th>상품가격</th>
                        <th>상품수량</th>
                        <th>등록일시</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="productList" items="${productList}">
                        <tr>
                            <td>${productList.row}</td>
                            <td>
                                <a href="/product/detail/${productList.productId}">${productList.productName}</a>
                            </td>
                            <td>${productList.productPrice}</td>
                            <td>${productList.productQty}</td>
                            <td>${productList.createdAt}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <%@ include file="layout/footer.jsp" %>