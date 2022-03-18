package com.lyj.springboot_jsp_shiro.service;

import com.lyj.springboot_jsp_shiro.entity.User;
import org.springframework.stereotype.Service;


public interface UserService {
    // 注册用户
    void register(User user);

    // 根据用户名查询业务
    User findByUserName(String username);
}
