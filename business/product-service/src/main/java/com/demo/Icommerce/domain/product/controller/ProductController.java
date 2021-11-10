package com.demo.Icommerce.domain.product.controller;

import com.demo.Icommerce.domain.product.payload.ProductResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RequestMapping("/product")
@RestController
public class ProductController {
    @GetMapping("/find")
    public List<ProductResponse> findProducts() {
        //
        return Collections.emptyList();
    }
}
