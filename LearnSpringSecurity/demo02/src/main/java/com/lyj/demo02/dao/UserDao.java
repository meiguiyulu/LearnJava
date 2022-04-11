package com.lyj.demo02.dao;

import com.lyj.demo02.entity.Role;
import com.lyj.demo02.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Mapper
public interface UserDao {

    // 根据用户名查询用户信息
    User loadUserByUsername(String username);

    // 根据用户id查询角色信息
    List<Role> getRolesByUid(Integer uid);
}
