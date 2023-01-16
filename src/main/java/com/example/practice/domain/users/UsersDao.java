package com.example.practice.domain.users;

import com.example.practice.web.dto.users.JoinSellerReqDto;

public interface UsersDao {

    // 판매자 회원가입
    public void insertSeller(JoinSellerReqDto joinSellerReqDto);
}
