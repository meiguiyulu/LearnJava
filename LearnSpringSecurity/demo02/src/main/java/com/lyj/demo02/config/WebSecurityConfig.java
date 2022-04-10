package com.lyj.demo02.config;

import com.lyj.demo02.handler.LoginFailureHandler;
import com.lyj.demo02.handler.LoginSuccessHandler;
import com.lyj.demo02.handler.MyLogoutSuccessHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /**
         * 注意：
         *  要放行的请求必须放在认证之前
         * */

        http.authorizeRequests() // 开启请求的权限管理
                .mvcMatchers("/login.html").permitAll()
                .mvcMatchers("/index").permitAll() // 放行 /index 请求
//                .mvcMatchers("/hello").authenticated() // 认证 /hello 请求
                .anyRequest().authenticated() // 对所有请求进行认证
                .and()
                .formLogin()
                .loginPage("/login.html") /** 自定义登录界面 注意：一定自定义登陆页面，就必须指定登录的url **/
                .loginProcessingUrl("/doLogin")  /** 指定处理登录请求的 url **/
/**
 *               修改form表单处 username 与 password 的参数名 默认是username与password
 *               .usernameParameter("uname")
 *               .passwordParameter("passwd")
 **/
                // .successForwardUrl("/hello") // 认证成功以后的跳转路径 使用的是forward跳转，跳转以后地址不变；会根据上一次请求的url进行跳转
                // .defaultSuccessUrl("/hello") //认证成功跳转  redirect的重定向跳转 地址会变；会根据上一次请求的url进行跳转
                .successHandler(new LoginSuccessHandler()) /*前后端分录处理登陆成功请求*/
                // .failureForwardUrl("/login.html") // 认证失败以后的跳转路径 使用的是forward跳转，跳转以后地址不变
                // .failureUrl("/login.html") //认证失败跳转  redirect的重定向跳转 地址会变
                .failureHandler(new LoginFailureHandler()) /*前后端分录自定义登陆失败处理方案*/
                .and()
                .logout()
/*                .logoutUrl("/logout") // 指定注销登录的url*/
                .logoutRequestMatcher(new OrRequestMatcher(
                        new AntPathRequestMatcher("/logout1", "POST"),
                        new AntPathRequestMatcher("/logout", "GET")
                ))
                .invalidateHttpSession(true) // 默认 会话失效
                .clearAuthentication(true) // 默认 清除认证标记
//                .logoutSuccessUrl("/login.html") // 注销登录成功之后跳转画面
                .logoutSuccessHandler(new MyLogoutSuccessHandler()) /*前后端分离 注销登录成功的处理*/
                .and()
                .csrf().disable(); // 禁止csrf 跨站请求保护
    }
}
