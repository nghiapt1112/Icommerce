package com.demo.Icommerce.domain.product.controller;

import com.demo.Icommerce.domain.product.payload.ProductFilter;
import com.demo.Icommerce.domain.product.payload.ProductResponse;
import com.demo.Icommerce.domain.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RequestMapping("/product")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/find")
    public List<ProductResponse> findProducts(@RequestParam ProductFilter filter) {
        List<ProductResponse> productResponses = productService.find(filter);
        return Collections.emptyList();
    }
}
