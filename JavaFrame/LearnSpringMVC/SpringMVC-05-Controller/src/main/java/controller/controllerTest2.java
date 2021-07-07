package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LYJ
 * @create 2021-07-07 14:44
 */

@Controller
public class controllerTest2 {
    @RequestMapping("/test2")
    public String printHello(Model model){

        model.addAttribute("msg", "controllerTest2");
        return "test";

    }
}
