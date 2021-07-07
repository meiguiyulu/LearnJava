package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author LYJ
 * @create 2021-07-07 15:26
 */
@Controller
public class controllerTest4 {

    /**
     * 原来的: http://localhost:8080/SpringMVC_05_Controller_war_exploded/add?a=1&b=2
     *
     */

    // http://localhost:8080/SpringMVC_05_Controller_war_exploded/add?a=1&b=2
    @RequestMapping("/add")
    public String test1(int a, int b, Model model){
        int res = a + b;
        model.addAttribute("msg", "结果是:\t" + res);
        return "test";
    }

    // http://localhost:8080/SpringMVC_05_Controller_war_exploded/add/1/2
    @RequestMapping(value = "/add/{a}/{b}", method = RequestMethod.GET)
    public String test2(@PathVariable int a, @PathVariable int b, Model model){
        int res = a + b;
        model.addAttribute("msg", "GET方式---->结果是:\t" + res);
        return "test";
    }
    // http://localhost:8080/SpringMVC_05_Controller_war_exploded/add/1/2
    @RequestMapping(value = "/add/{a}/{b}", method = RequestMethod.POST)
    public String test3(@PathVariable int a, @PathVariable int b, Model model){
        int res = a + b;
        model.addAttribute("msg", "POST方式---->结果是:\t" + res);
        return "test";
    }
}
