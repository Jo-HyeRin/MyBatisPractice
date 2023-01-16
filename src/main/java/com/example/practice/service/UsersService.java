package com.example.practice.service;

import org.springframework.stereotype.Service;

import com.example.practice.domain.users.UsersDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsersService {

    private final UsersDao usersDao;
}
