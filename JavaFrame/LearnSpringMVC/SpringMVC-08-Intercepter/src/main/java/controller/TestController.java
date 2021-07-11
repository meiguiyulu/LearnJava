package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LYJ
 * @create 2021-07-10 21:33
 */

@RestController
public class TestController {

    @RequestMapping("/test1")
    public String test1(){
        System.out.println("TestController");
        return "Test";
    }
}
