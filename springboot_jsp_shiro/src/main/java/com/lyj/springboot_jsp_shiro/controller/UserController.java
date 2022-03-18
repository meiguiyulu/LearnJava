package com.lyj.springboot_jsp_shiro.controller;

import com.lyj.springboot_jsp_shiro.entity.User;
import com.lyj.springboot_jsp_shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("login")
    public String login(String username, String password) {
        // 获取主体对象
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(new UsernamePasswordToken(username, password));
            return "index";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名错误！");
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            System.out.println("密码错误!");
        }
        return "login";
    }

    /**
     * 退出登录
     * @return
     */
    @RequestMapping("logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();;
        return "login";
    }

    /**
     * 注册
     */
    @RequestMapping("register")
    public String register(User user) {
//        System.out.println(user);
        try {
            userService.register(user);
            return "redirect:login";
        }catch (Exception e){
            e.printStackTrace();
            return "register";
        }
    }
}
