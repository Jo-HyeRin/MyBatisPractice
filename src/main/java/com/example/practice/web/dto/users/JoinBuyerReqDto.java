package com.example.practice.web.dto.users;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JoinBuyerReqDto {
    private String username;
    private String password;
    private String buyerName;
    private String buyerEmail;
    private Integer usersId;
    private Integer buyerId;
}
