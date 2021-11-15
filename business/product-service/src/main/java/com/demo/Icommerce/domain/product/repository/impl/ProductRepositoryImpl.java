package com.demo.Icommerce.domain.product.repository.impl;

import com.demo.Icommerce.domain.product.payload.ProductPageRequest;
import com.demo.Icommerce.domain.product.repository.ProductRepositoryCustom;
import com.demo.Icommerce.infrastructure.payload.BaseResponse;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements ProductRepositoryCustom<ProductPageRequest> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<? extends BaseResponse> find(ProductPageRequest productPageRequest) {
        StringBuilder query = new StringBuilder();
        Map<String, String> params = new HashMap<>();

        if (StringUtils.hasText(productPageRequest.getCategory())) {
            query.append("AND p.category = :category");
            params.put("category", productPageRequest.getCategory());
        }

        Query jpaQuery = this.entityManager.createQuery("" + query);
        if (!CollectionUtils.isEmpty(params)) {
            params.forEach((k, v) -> jpaQuery.setParameter(k, v));
        }
        return null;
    }
}
