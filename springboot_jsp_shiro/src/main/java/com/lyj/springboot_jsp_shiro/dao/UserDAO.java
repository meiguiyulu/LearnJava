package com.lyj.springboot_jsp_shiro.dao;

import com.lyj.springboot_jsp_shiro.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {
    void save(User user);

    User findByUserName(String username);
}
