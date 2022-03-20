package com.lyj.learnjwt.dao;

import com.lyj.learnjwt.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {
    User login(User user);
}
