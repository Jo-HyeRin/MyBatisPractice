package com.example.practice.domain.product;

import java.sql.Timestamp;

import com.example.practice.web.dto.ProductSaveReqDto;

import lombok.Getter;

@Getter
public class Product {
    private Integer productId;
    private String productName;
    private Integer productPrice;
    private Integer productQty;
    private Timestamp createdAt;

    // 상품등록
    public Product(ProductSaveReqDto productSaveReqDto) {
        this.productName = productSaveReqDto.getProductName();
        this.productPrice = productSaveReqDto.getProductPrice();
        this.productQty = productSaveReqDto.getProductQty();
    }
}
