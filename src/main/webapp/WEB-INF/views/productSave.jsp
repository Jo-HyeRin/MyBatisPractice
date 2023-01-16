<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="layout/header.jsp" %>

        <form action="/product/save" method="post">
            <div class="mb-3 mt-3">
                상품명 : <input id="productName" name="productName" type="text" placeholder="상품 이름을 적어주세요">
            </div>
            <div class="mb-3 mt-3">
                상품가격 : <input id="productPrice" name="productPrice" type="text" placeholder="상품 가격을 적어주세요">
            </div>
            <div class="mb-3 mt-3">
                상품수량 : <input id="productQty" name="productQty" type="text" placeholder="상품 수량을 적어주세요">
            </div>
            <button id="btnSave" type="submit" class="btn btn-primary">상품등록</button>
        </form>

        <%@ include file="layout/footer.jsp" %>