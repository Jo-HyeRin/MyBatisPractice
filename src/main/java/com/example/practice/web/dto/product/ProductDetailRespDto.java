package com.example.practice.web.dto.product;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDetailRespDto {
    private Integer productId;
    private String productName;
    private Integer productPrice;
    private Integer productQty;
    private Timestamp createdAt;
}
