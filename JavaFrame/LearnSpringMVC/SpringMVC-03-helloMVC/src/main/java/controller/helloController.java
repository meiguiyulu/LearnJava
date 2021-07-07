package controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author LYJ
 * @create 2021-07-06 20:25
 */
public class helloController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView();

        // 业务代码
        String result = "Hello SpringMVC";
        modelAndView.addObject("msg", result);

        // 视图跳转
        modelAndView.setViewName("test");

        return modelAndView;
    }
}
