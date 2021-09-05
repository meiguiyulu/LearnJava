package com.meiguiyulu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LYJ
 * @create 2021-07-15 18:35
 */

@RestController
public class helloController {


    @RequestMapping("/hello")
    public String test(){
        return "Hello, World!";
    }

}
