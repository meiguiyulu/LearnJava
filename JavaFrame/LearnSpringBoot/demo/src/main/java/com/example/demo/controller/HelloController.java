package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LYJ
 * @create 2021-04-23 16:12
 */
@RestController
class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
