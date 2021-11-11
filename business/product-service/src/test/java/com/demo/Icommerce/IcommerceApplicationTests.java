package com.demo.Icommerce;

import com.demo.Icommerce.domain.product.entity.Category;
import com.demo.Icommerce.domain.product.entity.Product;
import com.demo.Icommerce.domain.product.repository.CategoryRepository;
import com.demo.Icommerce.domain.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@SpringBootTest
class IcommerceApplicationTests {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	public void findAll() {
		List<Product> products = productRepository.findAll();
		System.out.println(products);
	}

	@Test
	public void createOne() {
		Category category = new Category();
		category.setName("Category - name 1");
		category.getProduct().add(new Product("name1", new BigDecimal(1000)));
		category.getProduct().add(new Product("name2", new BigDecimal(2000)));
		category.getProduct().add(new Product("name3", new BigDecimal(3000)));
		category.getProduct().add(new Product("name4", new BigDecimal(4000)));

		categoryRepository.save(category);

		System.out.println(categoryRepository.findAll());
		System.out.println(productRepository.findAll());
	}

}
