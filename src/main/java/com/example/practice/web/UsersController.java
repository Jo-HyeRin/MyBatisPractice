package com.example.practice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.practice.service.UsersService;
import com.example.practice.web.dto.ResponseDto;
import com.example.practice.web.dto.users.JoinBuyerReqDto;
import com.example.practice.web.dto.users.JoinSellerReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UsersController {

    private final UsersService usersService;

    // 아이디 중복체크
    @GetMapping("/users/samecheck/{username}")
    public @ResponseBody ResponseDto<?> sameCheckUsername(@PathVariable String username) {
        Boolean isSame = usersService.아이디중복체크(username);
        return new ResponseDto<>(1, "중복체크 성공", isSame);
    }

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

    // 구매자 회원가입
    @GetMapping("/join/buyer")
    public String joinBuyerForm() {
        return "/users/joinBuyer";
    }

    @PostMapping("/join/buyer")
    public @ResponseBody ResponseDto<?> joinBuyer(@RequestBody JoinBuyerReqDto joinbuyerReqDto) {
        usersService.구매자회원가입(joinbuyerReqDto);
        return new ResponseDto<>(1, "구매자 회원가입 성공", null);
    }

    @GetMapping("/login")
    public String loginForm() {
        return "/users/login";
    }

}
