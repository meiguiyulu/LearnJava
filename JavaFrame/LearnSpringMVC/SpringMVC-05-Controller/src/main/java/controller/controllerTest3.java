package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LYJ
 * @create 2021-07-07 14:53
 */
@Controller
@RequestMapping("/c3")
public class controllerTest3 {

    @RequestMapping("test3")
    public String test(Model model){
        model.addAttribute("msg", "Hello, this is controllerTest3");
        return "test";
    }
}
