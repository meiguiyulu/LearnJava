package com.lyj.learnjwt.config;

import com.lyj.learnjwt.jwt.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                        .excludePathPatterns("/user/**")  // 放行
                        .addPathPatterns("/**"); // 拦截除了"/user/**的所有请求路径
    }
}

