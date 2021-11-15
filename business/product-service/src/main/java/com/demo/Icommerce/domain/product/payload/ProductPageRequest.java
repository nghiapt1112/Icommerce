package com.demo.Icommerce.domain.product.payload;

import com.demo.Icommerce.infrastructure.payload.PageRequest;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductPageRequest extends PageRequest {
    private String category;
    private String name;
    private String branch;
    private String color;
    private BigDecimal price;
}
