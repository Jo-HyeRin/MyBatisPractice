package com.example.practice.domain.product;

import java.util.List;

import com.example.practice.web.dto.product.ProductDetailRespDto;
import com.example.practice.web.dto.product.ProductListRespDto;
import com.example.practice.web.dto.product.ProductSaveReqDto;

public interface ProductDao {
    // 상품상세보기
    public ProductDetailRespDto findById(Integer productId);

    // 상품목록
    public List<ProductListRespDto> findAll();

    // 상품등록
    public void insert(ProductSaveReqDto productSaveReqDto);

    // 상품수정
    public Product findByIdForUpdate(Integer productId);

    public void update(Product product);

    // 상품삭제
    public int deleteById(Integer productId);

    // 상품이름 중복체크
    public Product findByProductName(String productName);
}