package com.lyj.config;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义记住我 service 实现类
 */
public class MyRememberMeService extends PersistentTokenBasedRememberMeServices {

    public MyRememberMeService(String key, UserDetailsService userDetailsService, PersistentTokenRepository tokenRepository) {
        super(key, userDetailsService, tokenRepository);
    }

    /**
     * 自定义前后端分离获取 remember-me 方式
     *
     * @param request
     * @param parameter
     * @return
     */
    @Override
    protected boolean rememberMeRequested(HttpServletRequest request, String parameter) {
        String paramValue = request.getAttribute(parameter).toString();
        if (paramValue != null) {
            if (paramValue.equalsIgnoreCase("yes") || paramValue.equalsIgnoreCase("on")
                    || parameter.equalsIgnoreCase("yes") || parameter.equalsIgnoreCase("1")) {
                return true;
            }
        }
        return false;
    }
}
