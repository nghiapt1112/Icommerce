package com.demo.Icommerce.domain.product.repository;

import com.demo.Icommerce.infrastructure.payload.PageRequest;
import com.demo.Icommerce.infrastructure.repository.ICommerceRepository;

public interface ProductRepositoryCustom<E extends PageRequest> extends ICommerceRepository<E> {
}
