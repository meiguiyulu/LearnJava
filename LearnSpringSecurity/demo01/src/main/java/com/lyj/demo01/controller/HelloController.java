package com.lyj.demo01.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("Hello World");
        return "Hello World!";
    }
}

