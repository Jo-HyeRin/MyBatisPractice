<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../layout/header.jsp" %>

        <form>
            <div class="mb-3 mt-3">
                아이디 : <input id="username" name="username" type="text" placeholder="아이디를 입력해주세요">
                <button id="btnSameCheckUsername" type="button" class="btn btn-primary">아이디중복체크</button>
            </div>
            <div class="mb-3 mt-3">
                비밀번호 : <input id="password" name="password" type="text" placeholder="비밀번호를 입력해주세요">
            </div>
            <div class="mb-3 mt-3">
                비밀번호확인 : <input id="passwordCheck" name="passwordCheck" type="text" placeholder="비밀번호를 한번더 입력해주세요">
            </div>
            <button id="btnJoinBuyer" type="button" class="btn btn-primary">구매자회원가입</button>
        </form>

        <%@ include file="../layout/footer.jsp" %>