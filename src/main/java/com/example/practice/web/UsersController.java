package com.example.practice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.practice.service.UsersService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UsersController {

    private final UsersService usersService;

    @GetMapping("/join/seller")
    public String joinSellerForm() {
        return "/users/joinSeller";
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
