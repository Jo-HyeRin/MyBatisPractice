package com.example.practice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.practice.domain.product.ProductDao;
import com.example.practice.web.dto.ProductSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductDao productDao;

    @Transactional
    public void 상품등록(ProductSaveReqDto productSaveReqDto) {
        productDao.insert(productSaveReqDto);
    }
}
