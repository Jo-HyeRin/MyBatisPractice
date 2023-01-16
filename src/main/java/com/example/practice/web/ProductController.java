package com.example.practice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping({ "/", "main", "/product/list" })
    public String main() {
        return "productList";
    }

    @GetMapping("/product/save")
    public String productSave() {
        return "productSave";
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
