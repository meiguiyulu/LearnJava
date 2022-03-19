package com.lyj.springboot_jsp_shiro.service;

import com.lyj.springboot_jsp_shiro.dao.UserDAO;
import com.lyj.springboot_jsp_shiro.entity.Perms;
import com.lyj.springboot_jsp_shiro.entity.User;
import com.lyj.springboot_jsp_shiro.utils.SaltUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Override
    public void register(User user) {
        //处理业务调用dao
        //1.生成随机盐
        String salt = SaltUtils.getSalt(8);
        //2.将随机盐保存到数据
        user.setSalt(salt);
        //3.明文密码进行md5 + salt + hash散列
        Md5Hash md5Hash = new Md5Hash(user.getPassword(),salt,1024);
        user.setPassword(md5Hash.toHex());

        userDAO.save(user);
    }

    @Override
    public User findByUserName(String username) {
        User user = userDAO.findByUserName(username);
        return user;
    }

    @Override
    public List<Perms> findPermsByRoleId(Integer id) {
        return userDAO.findPermsByRoleId(id);
    }

    @Override
    public User findRolesByUserName(String username) {
        return userDAO.findRolesByUserName(username);
    }

}
