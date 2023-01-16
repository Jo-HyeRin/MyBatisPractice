package com.example.practice.domain.buyer;

import com.example.practice.web.dto.users.JoinBuyerReqDto;

public interface BuyerDao {

    // 구매자 회원가입
    public void insert(JoinBuyerReqDto joinBuyerReqDto);
}
