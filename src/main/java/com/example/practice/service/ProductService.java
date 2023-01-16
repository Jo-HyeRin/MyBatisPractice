package com.example.practice.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.practice.domain.product.Product;
import com.example.practice.domain.product.ProductDao;
import com.example.practice.web.dto.product.ProductDetailRespDto;
import com.example.practice.web.dto.product.ProductListRespDto;
import com.example.practice.web.dto.product.ProductSaveReqDto;
import com.example.practice.web.dto.product.ProductUpdateReqDto;

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

    public void 상품삭제(Integer productId) {
        productDao.deleteById(productId);
    }

    public Boolean 상품이름중복체크(String productName) {
        Product productPS = productDao.findByProductName(productName);
        if (productPS != null) {
            return true;
        } else {
            return false;
        }
    }
}
