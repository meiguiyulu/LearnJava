package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author LYJ
 * @create 2021-07-08 18:49
 */
@Controller
public class ModelTest1 {

    @RequestMapping("/m1/t1")
    public String test1(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        System.out.println("Session Id:\t" + session.getId());
        return "test";
    }
    @RequestMapping("/m1/t2")
    public String test2(HttpServletRequest request, HttpServletResponse response, Model model){
        HttpSession session = request.getSession();
        System.out.println("Session Id:\t" + session.getId());
        model.addAttribute("msg", "return '/test.jsp'");
        // 转发
        return "/WEB-INF/jsp/test.jsp";
    }
    @RequestMapping("/m1/t3")
    public String test3(HttpServletRequest request, HttpServletResponse response, Model model){
        HttpSession session = request.getSession();
        System.out.println("Session Id:\t" + session.getId());
        model.addAttribute("msg", "return 'forward:/WEB-INF/jsp/test.jsp/test.jsp'");
        // 转发
        return "forward:/WEB-INF/jsp/test.jsp";
    }
    @RequestMapping("/m1/t4")
    public String test4(HttpServletRequest request, HttpServletResponse response, Model model){
        HttpSession session = request.getSession();
        System.out.println("Session Id:\t" + session.getId());
        model.addAttribute("msg", "return 'redirect:/WEB-INF/jsp/test.jsp/test.jsp'");
        // 重定向
        return "redirect:/index.jsp";
    }
}
