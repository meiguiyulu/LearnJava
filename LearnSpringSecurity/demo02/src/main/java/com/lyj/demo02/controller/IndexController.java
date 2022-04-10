package com.lyj.demo02.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        System.out.println("Hello index");
        return "hello index";
    }

}
