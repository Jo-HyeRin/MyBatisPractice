package com.example.practice.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.practice.service.ProductService;
import com.example.practice.web.dto.ProductDetailRespDto;
import com.example.practice.web.dto.ProductListRespDto;
import com.example.practice.web.dto.ProductSaveReqDto;
import com.example.practice.web.dto.ProductUpdateReqDto;
import com.example.practice.web.dto.ResponseDto;

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
    public @ResponseBody ResponseDto<?> productSave(@RequestBody ProductSaveReqDto productSaveReqDto) {
        productService.상품등록(productSaveReqDto);
        return new ResponseDto<>(1, "상품등록 성공", null);
    }

    // 상품상세보기
    @GetMapping("/product/detail/{productId}")
    public String productDetail(@PathVariable Integer productId, Model model) {
        ProductDetailRespDto productDetail = productService.상품상세보기(productId);
        model.addAttribute("productDetail", productDetail);
        return "productDetail";
    }

    // 상품수정
    @GetMapping("/product/update/{productId}")
    public String productUpdateForm(@PathVariable Integer productId, Model model) {
        ProductDetailRespDto productDetail = productService.상품상세보기(productId);
        model.addAttribute("productDetail", productDetail);
        return "productUpdate";
    }

    @PostMapping("/product/update/{productId}")
    public String productUpdate(@PathVariable Integer productId, ProductUpdateReqDto productUpdateReqDto) {
        productService.상품수정(productId, productUpdateReqDto);
        return "redirect:/product/detail/" + productId;
    }

    // 상품삭제
    @PostMapping("/product/delete/{productId}")
    public String productDelete(@PathVariable Integer productId) {
        productService.상품삭제(productId);
        return "redirect:/";
    }

    // 상품이름 중복체크
    @GetMapping("/product/samecheck/{productName}")
    public @ResponseBody ResponseDto<?> sameCheckName(@PathVariable String productName) {
        Boolean isSame = productService.상품이름중복체크(productName);
        return new ResponseDto<>(1, "중복체크성공", isSame);
    }

}
