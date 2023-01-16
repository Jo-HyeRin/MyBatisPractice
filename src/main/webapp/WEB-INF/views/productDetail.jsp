<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="layout/header.jsp" %>

        <div class="container">
            <form>
                <div class="mb-3 mt-3">상품등록번호 : ${productDetail.productId}</div>
                <div class="mb-3 mt-3">상품명 : ${productDetail.productName}</div>
                <div class="mb-3 mt-3">상품가격 : ${productDetail.productPrice}</div>
                <div class="mb-3 mt-3">상품수량 : ${productDetail.productQty}</div>
                <div class="mb-3 mt-3">등록일시 : ${productDetail.createdAt}</div>
                <a href="/product/update/${productDetail.productId}">상품수정하기</a>
            </form>
        </div>

        <%@ include file="layout/footer.jsp" %>