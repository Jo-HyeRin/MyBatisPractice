package com.example.practice.domain.product;

import java.util.List;

import com.example.practice.web.dto.ProductListRespDto;
import com.example.practice.web.dto.ProductSaveReqDto;

public interface ProductDao {
    public Product findById(Integer productId);

    // 상품목록
    public List<ProductListRespDto> findAll();

    // 상품등록
    public void insert(ProductSaveReqDto productSaveReqDto);

    public int update(Product product);

    public int deleteById(Integer productId);
}