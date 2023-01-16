package com.example.practice.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.practice.service.ProductService;
import com.example.practice.web.dto.ProductListRespDto;
import com.example.practice.web.dto.ProductSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ProductController {

    private final ProductService productService;

    // 상품목록보기
    @GetMapping({ "/", "main", "/product/list" })
    public String productList(Model model) {
        List<ProductListRespDto> productList = productService.상품목록();
        model.addAttribute("productList", productList);
        return "productList";
    }

    // 상품등록
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
