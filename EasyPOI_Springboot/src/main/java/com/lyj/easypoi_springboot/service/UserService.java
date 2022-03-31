package com.lyj.easypoi_springboot.service;

import com.lyj.easypoi_springboot.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void saveAll(List<User> objects);
}
