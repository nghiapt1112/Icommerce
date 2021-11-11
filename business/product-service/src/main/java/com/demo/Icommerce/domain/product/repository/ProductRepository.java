package com.demo.Icommerce.domain.product.repository;

import com.demo.Icommerce.domain.product.entity.Product;
import com.demo.Icommerce.infrastructure.repository.ICommerceRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> , ICommerceRepository {

}
