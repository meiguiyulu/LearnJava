package com.lyj.easypoi_springboot.service;

import com.lyj.easypoi_springboot.dao.UserDAO;
import com.lyj.easypoi_springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    // 查询所有
    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    // 导入Excel
    @Override
    public void saveAll(List<User> objects) {
        objects.forEach(user -> {
            user.setId(null);
            userDAO.save(user);
        });
    }
}
