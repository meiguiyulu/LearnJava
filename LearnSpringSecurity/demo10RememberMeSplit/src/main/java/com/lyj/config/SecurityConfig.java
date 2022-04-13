package com.lyj.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

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

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    // 自定义 Filter 交给工厂
    @Bean
    public LoginFilter loginFilter() throws Exception {
        LoginFilter loginFilter = new LoginFilter();
        loginFilter.setFilterProcessesUrl("/doLogin");
        loginFilter.setUsernameParameter("uname");  // 指定请求 json 的用户名 key
        loginFilter.setPasswordParameter("pwd");    // 指定请求 json 的密码  key
        loginFilter.setAuthenticationManager(authenticationManagerBean());
        loginFilter.setRememberMeServices(rememberMeServices()); /** 设置认证成功以后使用自定义的RememberMeServices **/
        loginFilter.setAuthenticationSuccessHandler(((request, response, authentication) -> {
            Map<String, Object> map = new HashMap<>();
            map.put("msg", "登陆成功");
            map.put("authentication", authentication);
            response.setStatus(HttpStatus.OK.value());
            response.setContentType("application/json;charset=UTF-8");
            String string = new ObjectMapper().writeValueAsString(map);
            response.getWriter().println(string);
        }));
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
                .anyRequest().authenticated()
                .and()
                .formLogin() // 前后端分离系统需要重写formLogin的登陆实现 自定义UsernamePasswordAuthenticationFilter
                .and()
                .rememberMe() // 记住我
                .rememberMeServices(rememberMeServices()) /** 设置自动登录时候使用的RememberMeServices **/
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(((request, response, authException) -> {
                    response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    response.getWriter().println("请认证之后再去处理!");
                }))
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(((request, response, authentication) -> {
                    HashMap<String, Object> res = new HashMap<>();
                    res.put("msg", "退出成功");
                    res.put("exitingUser", authentication);
                    res.put("status", "200");
                    response.setContentType("application/json;charset=UTF-8");
                    String string = new ObjectMapper().writeValueAsString(res);
                    response.getWriter().print(string);
                }))
                .and()
                .csrf().disable();

        /**
         *         http.addFilterAt();       将自定义的 filter 替换过滤器链中的某个 filter
         *         http.addFilterBefore();   将自定义的 filter 替换过滤器链中某个 filter 之前
         *         http.addFilterAfter();    将自定义的 filter 替换过滤器链中某个 filter 之后
         */
        http.addFilterAt(loginFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    @Bean
    public RememberMeServices rememberMeServices() {
        return new MyRememberMeService(UUID.randomUUID().toString(), userDetailsService(), new InMemoryTokenRepositoryImpl());
    }
}
