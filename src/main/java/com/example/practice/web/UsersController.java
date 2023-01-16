package com.example.practice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.practice.service.UsersService;
import com.example.practice.web.dto.ResponseDto;
import com.example.practice.web.dto.users.JoinSellerReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UsersController {

    private final UsersService usersService;

    // 판매자 회원가입
    @GetMapping("/join/seller")
    public String joinSellerForm() {
        return "/users/joinSeller";
    }

    @PostMapping("/join/seller")
    public @ResponseBody ResponseDto<?> joinSeller(@RequestBody JoinSellerReqDto joinSellerReqDto) {
        usersService.판매자회원가입(joinSellerReqDto);
        return new ResponseDto<>(1, "판매자 회원가입 성공", null);
    }

    @GetMapping("/join/buyer")
    public String joinBuyerForm() {
        return "/users/joinBuyer";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "/users/login";
    }

}
