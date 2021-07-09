package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author LYJ
 * @create 2021-07-08 21:35
 */

@Controller
public class EncodingController {

    @PostMapping("/e/t1")
    public String test1(String name, Model model){
        model.addAttribute("msg", name);
        return "test";
    }

}
