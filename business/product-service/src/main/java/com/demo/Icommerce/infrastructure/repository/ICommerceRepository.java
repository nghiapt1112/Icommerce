package com.demo.Icommerce.infrastructure.repository;

import java.util.List;

public interface ICommerceRepository<PageRequest> {
    List<PageRequest> find();
}
