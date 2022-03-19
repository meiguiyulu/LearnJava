package com.lyj.springboot_jsp_shiro.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Perms implements Serializable {
    private Integer id;
    private String name;
    private String url;
}
