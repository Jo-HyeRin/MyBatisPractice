package com.example.practice.domain.users;

import com.example.practice.web.dto.users.JoinSellerReqDto;

public interface UsersDao {

    // 아이디 중복체크
    public Users findByUsername(String username);

    // 판매자 회원가입
    public void insertSeller(JoinSellerReqDto joinSellerReqDto);
}
