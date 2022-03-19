package com.lyj.springboot_jsp_shiro.entity;

import lombok.Data;

import java.util.List;

@Data
public class Role {
    private Integer id;
    private String name;

    // 定义权限的集合
    private List<Perms> perms;
}
