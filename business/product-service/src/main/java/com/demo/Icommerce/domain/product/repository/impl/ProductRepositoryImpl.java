package com.demo.Icommerce.domain.product.repository.impl;

import com.demo.Icommerce.domain.product.payload.ProductPageRequest;
import com.demo.Icommerce.domain.product.payload.ProductPageResponse;
import com.demo.Icommerce.domain.product.repository.ProductRepositoryCustom;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ProductRepositoryImpl implements ProductRepositoryCustom<ProductPageRequest> {
    private final String selectQuery = "SELECT p FROM Product p ";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ProductPageResponse find(ProductPageRequest productPageRequest) {
        StringBuilder condition = new StringBuilder("WHERE p.deleted <> TRUE ");
        Map<String, Object> params = new HashMap<>();

        if (StringUtils.hasText(productPageRequest.getCategory())) {
            condition.append("AND p.category = :category");
            params.put("category", productPageRequest.getCategory());
        }

        if (StringUtils.hasText(productPageRequest.getName())) {
            condition.append("AND p.name = :name");
            params.put("name", productPageRequest.getName());
        }
        if (StringUtils.hasText(productPageRequest.getBranch())) {
            condition.append("AND p.branch = :branch");
            params.put("branch", productPageRequest.getBranch());
        }
        if (StringUtils.hasText(productPageRequest.getColor())) {
            condition.append("AND p.color = :color");
            params.put("color", productPageRequest.getColor());
        }
        if (Objects.nonNull(productPageRequest.getPrice())) {
            condition.append("AND p.price = :price");
            params.put("price", productPageRequest.getPrice());
        }

        Query jpaQuery = this.entityManager.createQuery(selectQuery + condition);
        if (!CollectionUtils.isEmpty(params)) {
            params.forEach((k, v) -> jpaQuery.setParameter(k, v));
        }
        jpaQuery.setFirstResult(productPageRequest.getFirstResult());
        jpaQuery.setMaxResults(productPageRequest.getSize());

        long count = this.getTotalResult(condition, params);

        ProductPageResponse productPageResponse = new ProductPageResponse(productPageRequest.getPage(), productPageRequest.getSize(), count);
        productPageResponse.parse(jpaQuery.getResultList());
        return productPageResponse;
    }

    private long getTotalResult(StringBuilder condition, Map<String, Object> params) {
        Query totalQuery = entityManager.createQuery("SELECT COUNT(p.productId) FROM Product p " + condition);
        params.forEach((k, v) -> totalQuery.setParameter(k, v));
        return (long) totalQuery.getSingleResult();
    }
}
