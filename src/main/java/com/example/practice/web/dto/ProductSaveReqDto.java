package com.example.practice.web.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductSaveReqDto {
    private Integer productId;
    private String productName;
    private Integer productPrice;
    private Integer productQty;
}
