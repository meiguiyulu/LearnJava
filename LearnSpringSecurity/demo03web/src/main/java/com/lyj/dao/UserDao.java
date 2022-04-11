package com.lyj.dao;

import com.lyj.entity.Role;
import com.lyj.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    // 根据用户名查询用户信息
    User loadUserByUsername(String username);

    // 根据用户id查询角色信息
    List<Role> getRolesByUid(Integer uid);
}
