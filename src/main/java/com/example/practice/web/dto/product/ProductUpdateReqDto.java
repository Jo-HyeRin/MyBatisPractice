package com.example.practice.web.dto.product;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductUpdateReqDto {
    private String productName;
    private Integer productPrice;
    private Integer productQty;
}
