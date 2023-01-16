package com.example.practice.domain.product;

import java.util.List;

import com.example.practice.web.dto.ProductSaveReqDto;

public interface ProductDao {
    public Product findById(Integer productId);

    public List<Product> findAll();

    // 상품등록
    public void insert(ProductSaveReqDto productSaveReqDto);

    public int update(Product product);

    public int deleteById(Integer productId);
}