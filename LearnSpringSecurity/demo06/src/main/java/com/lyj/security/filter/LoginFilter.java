package com.lyj.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lyj.security.exception.KaptchaNotMatchException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 自定义登录的Filter
 */
public class LoginFilter extends UsernamePasswordAuthenticationFilter {

    public static final String FORM_KAPTCHA_KEY = "kaptcha";

    private String kaptchaParameter = FORM_KAPTCHA_KEY;

    public String getKaptchaParameter() {
        return kaptchaParameter;
    }

    public void setKaptchaParameter(String kaptchaParameter) {
        this.kaptchaParameter = kaptchaParameter;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals("post")) {
            throw new AuthenticationServiceException("Authentication method is not supported: " + request.getMethod());
        }
        // 1. 获取请求验证码
        try {
            Map<String, String> userInfo = new ObjectMapper().readValue(request.getInputStream(), Map.class);
            String codeFromRequest = userInfo.get(getKaptchaParameter());  // 请求中的验证码
            String username = userInfo.get(getUsernameParameter());  // 请求中的用户名
            String password = userInfo.get(getPasswordParameter()); // 请求中的密码

            // 2. 获取session或者redis中的验证码
            String codeFromSession = (String) request.getSession().getAttribute("kaptcha");
            if (!ObjectUtils.isEmpty(codeFromSession) && !ObjectUtils.isEmpty(codeFromRequest)
                    && codeFromSession.equalsIgnoreCase(codeFromRequest)) {
                // 3. 获取用户名和密码认证
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
                setDetails(request, token);
                return this.getAuthenticationManager().authenticate(token);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new UsernameNotFoundException("验证码不正确");
/*        try {
            throw new KaptchaNotMatchException("验证码不正确");
        } catch (KaptchaNotMatchException e) {
            e.printStackTrace();
            return null;
        }*/
    }
}
