package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.User;

/**
 * @author LYJ
 * @create 2021-07-08 19:39
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/t1")
    public String test1(String name, Model model){
        // 1、接受前端参数
        System.out.println("接收到前端的参数: " + name);
        // 2、将接收到的参数传递给前端
        model.addAttribute("msg", name);
        // 3、视图跳转
        return "test";
    }

    /**
     * 前端接收一个对象
     * 1、接收前端用户传递的参数, 判断参数的名字, 假设名字在方法上, 可以直接使用
     * 2、假设传递的是一个对象, 匹配对象中的字段名；如果匹配到则正确传递, 否则为匹配到的字段为null。
     */
    @GetMapping("/t2")
    public String test2(User user, Model model){
        String str = user.toString();
        model.addAttribute("msg", str);
        return "test";
    }

    @GetMapping("/t3")
    public String test3(ModelMap modelMap){
        modelMap.addAttribute("msg", "modelMap");
        return "test";
    }
}
