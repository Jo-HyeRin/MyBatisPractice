package com.example.practice.domain.seller;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Seller {
    private Integer sellerId;
    private String sellerName;
    private String sellerEmail;
    private Integer usersId;
    private Timestamp createdAt;
}