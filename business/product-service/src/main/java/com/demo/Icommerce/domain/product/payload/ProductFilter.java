package com.demo.Icommerce.domain.product.payload;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductFilter {
    private String category;
    private BigDecimal price;
    private String brand;
    private String colour;
}
