package com.demo.Icommerce.domain.product.service.impl;

import com.demo.Icommerce.domain.product.payload.ProductFilter;
import com.demo.Icommerce.domain.product.payload.ProductPageResponse;
import com.demo.Icommerce.domain.product.repository.ProductRepository;
import com.demo.Icommerce.domain.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductPageResponse> find(ProductFilter filter) {
        return null;
    }
}
