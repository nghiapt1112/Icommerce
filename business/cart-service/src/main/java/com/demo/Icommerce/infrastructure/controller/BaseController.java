package com.demo.Icommerce.infrastructure.controller;

import com.demo.Icommerce.infrastructure.exception.BaseException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BaseController {
    @ExceptionHandler(Exception.class)
    public void handleRootException(BaseException exception) {

    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.initDirectFieldAccess();
    }

}
