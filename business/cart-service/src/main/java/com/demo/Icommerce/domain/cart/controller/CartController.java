package com.demo.Icommerce.domain.cart.controller;

import com.demo.Icommerce.domain.cart.entity.Cart;
import com.demo.Icommerce.domain.cart.service.CartService;
import com.demo.Icommerce.infrastructure.logger.IcommerceLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RequestMapping("/cart")
@RestController
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping()
    public void findProducts(Collection<Long> productIds) {
        IcommerceLogger.logger.info("[CartController] addToCart: " + productIds);
        cartService.addToCard(productIds);
    }

    @GetMapping("/find")
    public List<Cart> findAll() {
        return cartService.findAll();
    }

    @GetMapping("/find/{id}")
    public Cart findDetail(@PathVariable Long id) {
        return cartService.findById(id);
    }

}
