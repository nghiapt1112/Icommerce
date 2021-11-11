package com.demo.Icommerce.domain.product.service;

import com.demo.Icommerce.domain.product.payload.ProductFilter;
import com.demo.Icommerce.domain.product.payload.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> find(ProductFilter filter);
}
