package com.lyj.springboot_jsp_shiro.entity;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String salt;

    // 定义角色集合
    private List<Role> roles;

}
