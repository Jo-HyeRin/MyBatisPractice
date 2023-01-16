package com.example.practice.domain.users;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Users {
    private Integer usersId;
    private String username;
    private String password;
    private String role;
    private Timestamp createdAt;
}
