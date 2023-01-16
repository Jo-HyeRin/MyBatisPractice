package com.example.practice.domain.buyer;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Buyer {
    private Integer buyerId;
    private String buyerName;
    private String buyerEmail;
    private Integer usersId;
    private Timestamp createdAt;
}
