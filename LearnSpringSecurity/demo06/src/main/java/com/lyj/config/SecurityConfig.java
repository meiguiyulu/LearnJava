package com.lyj.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lyj.security.filter.LoginFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 自定义数据源
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("root").password("{noop}123").roles("admin").build());
        return manager;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    // 配置自定义过滤器
    @Bean
    public LoginFilter loginFilter() throws Exception {
        LoginFilter loginFilter = new LoginFilter();
        // 1. 认证url
        loginFilter.setFilterProcessesUrl("/doLogin");
        // 2. 认证的接收参数
        loginFilter.setUsernameParameter("uname");
        loginFilter.setPasswordParameter("passwd");
        loginFilter.setKaptchaParameter("kaptcha");
        // 3. 指定认证管理器
        loginFilter.setAuthenticationManager(authenticationManagerBean());
        // 4. 指定成功时的响应
        loginFilter.setAuthenticationSuccessHandler(((request, response, authentication) -> {
            Map<String, Object> map = new HashMap<>();
            map.put("msg", "登陆成功");
            map.put("authentication", authentication);
            response.setStatus(HttpStatus.OK.value());
            response.setContentType("application/json;charset=UTF-8");
            String string = new ObjectMapper().writeValueAsString(map);
            response.getWriter().println(string);
        }));
        // 5. 指定失败时的响应
        loginFilter.setAuthenticationFailureHandler(((request, response, exception) -> {
            Map<String, Object> map = new HashMap<>();
            map.put("msg", "登录失败");
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            String string = new ObjectMapper().writeValueAsString(map);
            response.getWriter().println(string);
        }));

        return loginFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/vc.jpg").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(((request, response, authException) -> {
                    response.setContentType("application/json;charset=UTF-8");
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    response.getWriter().println("必须认证以后才能访问");
                }))
                .and()
                .logout()
                .and()
                .csrf().disable();

        http.addFilterAt(loginFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
