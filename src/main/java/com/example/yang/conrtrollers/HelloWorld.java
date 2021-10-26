package com.example.yang.conrtrollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: yy
 * date: 2021年4月24日
 */
@RestController
@RequestMapping("/hello")
public class HelloWorld {
    @RequestMapping("/world")
    public String sayHi() {
        return "hello world";
    }
}

