package controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.User;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LYJ
 * @create 2021-07-10 16:46
 */

@RestController
public class AjaxController {

    @RequestMapping("/t1")
    public String test1(){
        return "测试好不好使";
    }

    @RequestMapping("/t2")
    public void test2(String name, HttpServletResponse response) throws IOException {
        System.out.println("test--name==>" + name);
        if ("yunxiaojie".equals(name)){
            response.getWriter().print("true");
        } else {
            response.getWriter().print("false");
        }
    }

    @RequestMapping("/test3")
    public List<User> test3(){
        List<User> list = new ArrayList<>();

        list.add(new User("云杰1号", 18, "男"));
        list.add(new User("云杰2号", 23, "男"));
        list.add(new User("云杰3号", 19, "男"));

        return list;
    }

    @RequestMapping("/test4")
    public String test4(String name, String pwd){
        String msg = "";
        // 以下只是例子，真实数据应该从数据库中获取
        if (name != null){
            if ("admin".equals(name)){
                msg = "OK";
            } else {
                msg = "用户名有误";
            }
        }
        if (pwd != null) {
            if ("123456".equals(pwd)) {
                msg = "OK";
            } else {
                msg = "密码有误";
            }
        }
        return msg;
    }
}
