package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author LYJ
 * @create 2021-07-11 10:26
 */

@Controller
@RequestMapping("/user")
public class loginController {

    @RequestMapping("/toMain")
    public String toMain(){
        return "main";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String Login(String username, String password, HttpSession session){
        /**
         * 登陆成功, 跳转到成功页面, 并且把用户的信息存在session中
         */
        session.setAttribute("userLoginInfo", username);
        return "main";
    }

    @RequestMapping("/logout")
    public String loginOut(String username, String password, HttpSession session){
        /**
         * 注销
         */
        session.removeAttribute("userInfo");
        return "login";
    }
}
