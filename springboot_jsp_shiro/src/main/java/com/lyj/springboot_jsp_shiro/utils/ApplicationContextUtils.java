package com.lyj.springboot_jsp_shiro.utils;

import com.lyj.springboot_jsp_shiro.entity.User;
import com.lyj.springboot_jsp_shiro.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextUtils implements ApplicationContextAware {

    private ApplicationContext context;
    @Autowired
    UserService userService;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

}
