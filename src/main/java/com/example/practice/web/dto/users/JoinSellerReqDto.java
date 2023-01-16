package com.example.practice.web.dto.users;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JoinSellerReqDto {
    private String username;
    private String password;
    private String sellerName;
    private String sellerEmail;
    private Integer usersId;
    private Integer sellerId;
}
