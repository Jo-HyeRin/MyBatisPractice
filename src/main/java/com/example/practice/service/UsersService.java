package com.example.practice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.practice.domain.seller.SellerDao;
import com.example.practice.domain.users.UsersDao;
import com.example.practice.web.dto.users.JoinSellerReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsersService {

    private final UsersDao usersDao;
    private final SellerDao sellerDao;

    @Transactional
    public void 판매자회원가입(JoinSellerReqDto joinSellerReqDto) {
        // 유저 등록
        usersDao.insertSeller(joinSellerReqDto);
        // 셀러 등록
        sellerDao.insert(joinSellerReqDto);
    }
}
