package com.example.practice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.practice.domain.buyer.BuyerDao;
import com.example.practice.domain.seller.SellerDao;
import com.example.practice.domain.users.Users;
import com.example.practice.domain.users.UsersDao;
import com.example.practice.web.dto.users.JoinBuyerReqDto;
import com.example.practice.web.dto.users.JoinSellerReqDto;
import com.example.practice.web.dto.users.LoginDto;
import com.example.practice.web.dto.users.SignedDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsersService {

    private final UsersDao usersDao;
    private final SellerDao sellerDao;
    private final BuyerDao buyerDao;

    public Boolean 아이디중복체크(String username) {
        Users usersPS = usersDao.findByUsername(username);
        if (usersPS != null) {
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public void 판매자회원가입(JoinSellerReqDto joinSellerReqDto) {
        // 유저 등록
        usersDao.insertSeller(joinSellerReqDto);
        // 셀러 등록
        sellerDao.insert(joinSellerReqDto);
    }

    @Transactional
    public void 구매자회원가입(JoinBuyerReqDto joinBuyerReqDto) {
        // 유저 등록
        usersDao.insertBuyer(joinBuyerReqDto);
        // 셀러 등록
        buyerDao.insert(joinBuyerReqDto);
    }

    @Transactional
    public SignedDto 로그인(LoginDto loginDto) {
        SignedDto principal = usersDao.findByUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword());

        if (principal == null) {
            return null;
        }

        return principal;
    }
}
