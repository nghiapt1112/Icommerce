package com.demo.Icommerce.domain.product.controller;

import com.demo.Icommerce.infrastructure.logger.IcommerceLogger;
import com.demo.Icommerce.infrastructure.util.JsonUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {
    @PostMapping
    public Object post(@RequestBody Object o) {
        IcommerceLogger.logger.info("[UserController]" + JsonUtils.toJson(o));
        return o;
    }
}
