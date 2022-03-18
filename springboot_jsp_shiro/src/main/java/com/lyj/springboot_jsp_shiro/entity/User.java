package com.lyj.springboot_jsp_shiro.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String salt;
}
