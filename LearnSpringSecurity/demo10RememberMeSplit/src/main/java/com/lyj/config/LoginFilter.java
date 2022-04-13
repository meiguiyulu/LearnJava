package com.lyj.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 自定义前后端分离 Filter
 */

public class LoginFilter extends UsernamePasswordAuthenticationFilter {
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        /**
         * 1. 判断是否是 post 请求
         * 2. 判断是否是 json 格式请求类型
         * 3. 从json数据中获取用户输入的用户名和密码进行验证
         */
        // 判断是否是 post 请求
        if (!request.getMethod().equals("post")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }

        // 2. 判断是否是 json 格式请求类型
        if (request.getContentType().equalsIgnoreCase(MediaType.APPLICATION_JSON_VALUE)) {
            // 3. 从json数据中获取用户输入的用户名和密码进行验证 {"":xxx, "":xxx, "remember-me":""}
            try {
                Map<String, String> userInfo = new ObjectMapper().readValue(request.getInputStream(), Map.class);
                String username = userInfo.get(getUsernameParameter());
                String password = userInfo.get(getPasswordParameter());

                String rememberMe = userInfo.get(AbstractRememberMeServices.DEFAULT_PARAMETER);
                if (!ObjectUtils.isEmpty(rememberMe)) {
                    request.setAttribute(AbstractRememberMeServices.DEFAULT_PARAMETER, rememberMe);
                }
                System.out.println("用户名: " + username + " 密码: " + password + " 是否记住我: " + rememberMe);

                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
                setDetails(request, authenticationToken);
                return this.getAuthenticationManager().authenticate(authenticationToken);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.attemptAuthentication(request, response);
    }
}
