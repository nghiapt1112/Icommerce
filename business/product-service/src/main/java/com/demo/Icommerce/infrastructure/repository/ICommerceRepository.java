package com.demo.Icommerce.infrastructure.repository;

import com.demo.Icommerce.infrastructure.payload.BasePageResponse;
import com.demo.Icommerce.infrastructure.payload.PageRequest;

public interface ICommerceRepository<E extends PageRequest> {
    <P extends BasePageResponse> P find(E e);
}
