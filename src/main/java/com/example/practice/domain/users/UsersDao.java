package com.example.practice.domain.users;

import org.apache.ibatis.annotations.Param;

import com.example.practice.web.dto.users.JoinBuyerReqDto;
import com.example.practice.web.dto.users.JoinSellerReqDto;
import com.example.practice.web.dto.users.SignedDto;

public interface UsersDao {

    // 아이디 중복체크
    public Users findByUsername(String username);

    // 판매자 회원가입
    public void insertSeller(JoinSellerReqDto joinSellerReqDto);

    // 구매자 회원가입
    public void insertBuyer(JoinBuyerReqDto joinBuyerReqDto);

    // 로그인
    public SignedDto findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
