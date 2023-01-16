<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../layout/header.jsp" %>

        <form>
            <div class="mb-3 mt-3">
                아이디 : <input id="username" name="username" type="text" placeholder="아이디를 적어주세요">
            </div>
            <div class="mb-3 mt-3">
                비밀번호 : <input id="password" name="password" type="text" placeholder="비밀번호를 적어주세요">
            </div>
            <button id="btnLogin" type="button" class="btn btn-primary">로그인</button>
            <button id="btnJoinSeller" type="button" class="btn btn-primary">판매자회원가입</button>
            <button id="btnJoinBuyer" type="button" class="btn btn-primary">구매자회원가입</button>
        </form>

        <script>
            $("#btnJoinSeller").click(() => {
                location.href = "/join/seller";
            });
            $("#btnJoinBuyer").click(() => {
                location.href = "/join/buyer";
            });
        </script>

        <%@ include file="../layout/footer.jsp" %>