package com.lyj.demo02.handler;

import com.lyj.demo02.dao.UserDao;
import com.lyj.demo02.entity.Role;
import com.lyj.demo02.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.ObjectUtils;

import java.util.List;

@Component
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1.查询用户
        User user = userDao.loadUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不正确");
        }
        // 2. 权限查询
        List<Role> roles = userDao.getRolesByUid(user.getId());
        user.setRoles(roles);
        return user;
    }
}
