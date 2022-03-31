package com.lyj.easypoi_springboot.dao;

import com.lyj.easypoi_springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDAO {
    List<User> findAll();

    void save(User user);
}
