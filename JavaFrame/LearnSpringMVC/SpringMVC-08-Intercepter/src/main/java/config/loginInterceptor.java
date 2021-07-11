package config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author LYJ
 * @create 2021-07-11 10:43
 */
public class loginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 登录可以放行, 此时session中有对象
        HttpSession session = request.getSession();
        if (session.getAttribute("userInfo")!=null){
            return true;
        }
        // 或者是直接进入登陆页面, 可以放行
        if (request.getRequestURI().contains("login")){
            return true;
        }

        // 用户没有登陆跳转到登陆页面
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        return false;
    }
}
