package com.lyj.springboot_jsp_shiro.service;

import com.lyj.springboot_jsp_shiro.entity.Perms;
import com.lyj.springboot_jsp_shiro.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    // 注册用户
    void register(User user);

    // 根据用户名查询业务
    User findByUserName(String username);

    //根据用户名查询所有角色
    User findRolesByUserName(String username);
    //根据角色id查询权限集合
    List<Perms> findPermsByRoleId(Integer id);

}
