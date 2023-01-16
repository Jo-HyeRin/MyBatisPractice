<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="layout/header.jsp" %>

        <form>
            <div class="mb-3 mt-3">
                상품명 : <input id="productName" name="productName" type="text" placeholder="상품 이름을 적어주세요">
                <button id="btnSameCheckName" type="button" class="btn btn-primary">상품이름중복체크</button>
            </div>
            <div class="mb-3 mt-3">
                상품가격 : <input id="productPrice" name="productPrice" type="text" placeholder="상품 가격을 적어주세요">
            </div>
            <div class="mb-3 mt-3">
                상품수량 : <input id="productQty" name="productQty" type="text" placeholder="상품 수량을 적어주세요">
            </div>
            <button id="btnSave" type="button" class="btn btn-primary">상품등록</button>
        </form>

        <script>
            let isSameCheckName = false;

            $("#btnSave").click(() => {
                if (isSameCheckName == false) {
                    alert("상품이름 중복체크를 해주세요");
                    return;
                }

                if (koreanCheckPrice()) {
                    alert("가격에는 숫자만 입력하세요");
                    return;
                }

                if (koreanCheckQty()) {
                    alert("수량에는 숫자만 입력하세요");
                    return;
                }

                if (blankCheckPrice() == false) {
                    alert("가격에 공백이 있으면 안됩니다");
                    return;
                }

                if (blankCheckQty() == false) {
                    alert("수량에 공백이 있으면 안됩니다");
                    return;
                }

                saveProduct();
            });

            function saveProduct() {
                let data = {
                    productName: $("#productName").val(),
                    productPrice: $("#productPrice").val(),
                    productQty: $("#productQty").val(),
                };

                $.ajax("/product/save", {
                    type: "POST",
                    dataType: "json",
                    data: JSON.stringify(data),
                    headers: {
                        "Content-Type": "application/json; charset=utf-8"
                    },
                }).done((res) => {
                    if (res.code == 1) {
                        alert("상품등록 성공");
                        location.href = "/";
                    } else {
                        alert("상품등록 실패");
                        history.back();
                    }
                });
            }

            // 중복체크
            $("#btnSameCheckName").click(() => {
                sameCheckName();
            });

            function sameCheckName() {
                let productName = $("#productName").val();

                $.ajax("/product/samecheck/" + productName, {
                    type: "GET",
                    dataType: "json",
                    async: true
                }).done((res) => {
                    if (res.code == 1) {
                        if (res.data == false) {
                            alert("중복이 아닙니다. 사용할 수 있습니다.");
                            isSameCheckName = true;
                        } else {
                            alert("중복입니다. 다른 이름을 사용하세요.");
                            isSameCheckName = false;
                            $("#productName").val("");
                        }
                    }
                });
            }

            // 한글체크
            function koreanCheckPrice() {
                let productPrice = $("#productPrice").val();

                let korRule = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
                if (korRule.test(productPrice)) {
                    return true;
                } else {
                    return false;
                }
            }

            function koreanCheckQty() {
                let productQty = $("#productQty").val();

                let korRule = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
                if (korRule.test(productQty)) {
                    return true;
                } else {
                    return false;
                }

            }

            // 공백체크
            function blankCheckPrice() {
                let productPrice = $("#productPrice").val();
                let reg = /\s/g;

                if (reg.test(productPrice)) {
                    return false;
                } else {
                    return true;
                }
            }

            function blankCheckQty() {
                let productQty = $("#productQty").val();
                let reg = /\s/g;

                if (reg.test(productQty)) {
                    return false;
                } else {
                    return true;
                }
            }

        </script>

        <%@ include file="layout/footer.jsp" %>