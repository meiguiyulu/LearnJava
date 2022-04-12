package com.lyj.security.filter;

import com.lyj.security.exception.KaptchaNotMatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义验证码的Filter
 */

public class KaptchaFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        // 判断是否是 post 请求
        if (!request.getMethod().equals("post")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        // 1. 从请求中获取验证码
        String codeFormRequest = request.getParameter("kaptcha"); // 与 html中的name匹配
        // 2. 从session中获取验证码
        String codeFromSession = (String) request.getSession().getAttribute("kaptcha");

        if (codeFromSession != null && codeFromSession.equalsIgnoreCase(codeFormRequest)) {
            return super.attemptAuthentication(request, response);
        }
        try {
            System.out.println("*9***************");
            throw new KaptchaNotMatchException("验证码不匹配");
        } catch (KaptchaNotMatchException e) {
            e.printStackTrace();
        }
        return super.attemptAuthentication(request, response);
    }

    /**
     * 解决 spring security Invocation of init method failed; nested exception is java.lang.IllegalArgumentException: authenticationManager must be specified 问题
     * @param authenticationManager
     */
    @Autowired
    @Override
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }
}
