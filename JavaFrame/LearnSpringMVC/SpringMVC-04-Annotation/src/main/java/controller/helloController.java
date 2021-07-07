package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LYJ
 * @create 2021-07-07 13:17
 */
@Controller
//@RequestMapping("/hello")
public class helloController {

    // localhost:8080/h1
    @RequestMapping("/h1")
    public String Hello(Model model){
        model.addAttribute("msg", "Hello SpringMVC");
        return "hello";  // 会被视图解析器处理
    }
}
