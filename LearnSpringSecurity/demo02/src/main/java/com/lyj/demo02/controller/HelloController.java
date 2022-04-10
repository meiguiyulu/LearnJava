package com.lyj.demo02.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("Hello Spring Security");
        // 1. 获取认证信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("身份信息: " + authentication.getPrincipal());
        System.out.println("权限信息: " + authentication.getAuthorities());
        return "Hello Spring Security";
    }
}
