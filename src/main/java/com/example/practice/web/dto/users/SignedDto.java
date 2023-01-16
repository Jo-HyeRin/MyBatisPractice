package com.example.practice.web.dto.users;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignedDto {
    private Integer usersId;
    private String username;
    private String role;
}
