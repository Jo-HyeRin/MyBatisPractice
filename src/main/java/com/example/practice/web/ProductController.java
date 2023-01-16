package com.example.practice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.practice.service.ProductService;
import com.example.practice.web.dto.ProductSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ProductController {

    private final ProductService productService;

    @GetMapping({ "/", "main", "/product/list" })
    public String main() {
        return "productList";
    }

    @GetMapping("/product/save")
    public String productSaveForm() {
        return "productSave";
    }

    @PostMapping("/product/save")
    public String productSave(ProductSaveReqDto productSaveReqDto) {
        productService.상품등록(productSaveReqDto);
        return "redirect:/";
    }

    @GetMapping("/product/detail")
    public String productDetail() {
        return "productDetail";
    }

    @GetMapping("/product/update")
    public String productUpdate() {
        return "productUpdate";
    }

}
