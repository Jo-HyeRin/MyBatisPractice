package com.example.practice.domain.seller;

import com.example.practice.web.dto.users.JoinSellerReqDto;

public interface SellerDao {

    // 판매자 회원가입
    public void insert(JoinSellerReqDto joinSellerReqDto);
}
