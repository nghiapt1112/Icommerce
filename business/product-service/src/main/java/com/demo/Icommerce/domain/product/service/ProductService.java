package com.demo.Icommerce.domain.product.service;

import com.demo.Icommerce.domain.product.payload.ProductFilter;
import com.demo.Icommerce.domain.product.payload.ProductPageResponse;

import java.util.List;

public interface ProductService {
    List<ProductPageResponse> find(ProductFilter filter);
}
