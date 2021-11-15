package com.demo.Icommerce.infrastructure.repository;

import com.demo.Icommerce.infrastructure.payload.BaseResponse;
import com.demo.Icommerce.infrastructure.payload.PageRequest;

import java.util.List;

public interface ICommerceRepository<E extends PageRequest> {
    List<? extends BaseResponse> find(E e);
}
