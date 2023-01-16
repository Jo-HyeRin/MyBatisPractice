package com.example.practice.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.practice.domain.product.Product;
import com.example.practice.domain.product.ProductDao;
import com.example.practice.web.dto.ProductDetailRespDto;
import com.example.practice.web.dto.ProductListRespDto;
import com.example.practice.web.dto.ProductSaveReqDto;
import com.example.practice.web.dto.ProductUpdateReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductDao productDao;

    @Transactional
    public void 상품등록(ProductSaveReqDto productSaveReqDto) {
        productDao.insert(productSaveReqDto);
    }

    public List<ProductListRespDto> 상품목록() {
        return productDao.findAll();
    }

    public ProductDetailRespDto 상품상세보기(Integer productId) {
        return productDao.findById(productId);
    }

    public void 상품수정(Integer productId, ProductUpdateReqDto productUpdateReqDto) {
        Product productPS = productDao.findByIdForUpdate(productId);
        productPS.update(productUpdateReqDto);
        productDao.update(productPS);
    }
}
