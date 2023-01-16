package com.example.practice.domain.product;

import java.sql.Timestamp;

import com.example.practice.web.dto.ProductSaveReqDto;
import com.example.practice.web.dto.ProductUpdateReqDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
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

    // 상품수정
    public void update(ProductUpdateReqDto productUpdateReqDto) {
        this.productName = productUpdateReqDto.getProductName();
        this.productPrice = productUpdateReqDto.getProductPrice();
        this.productQty = productUpdateReqDto.getProductQty();
    }
}
