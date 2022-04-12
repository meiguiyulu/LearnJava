package com.lyj.config;

import com.lyj.security.filter.KaptchaFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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

/*
    @Autowired
    private KaptchaFilter kaptchaFilter;
    */

    @Bean
    public KaptchaFilter kaptchaFilter() throws Exception {
        KaptchaFilter kaptchaFilter = new KaptchaFilter();
        kaptchaFilter.setFilterProcessesUrl("/doLogin");
        kaptchaFilter.setUsernameParameter("uname");
        kaptchaFilter.setPasswordParameter("pwd");
        // 指定认证管理器
        kaptchaFilter.setAuthenticationManager(authenticationManagerBean());
        // 指定认证成功处理
        kaptchaFilter.setAuthenticationSuccessHandler(((request, response, authentication) -> {
            response.sendRedirect("/index.html");
        }));
        // 指定认证失败处理
        kaptchaFilter.setAuthenticationFailureHandler(((request, response, exception) -> {
            response.sendRedirect("/login.html");
        }));
        return new KaptchaFilter();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/login.html").permitAll()
                .mvcMatchers("/vc.jpg").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
//                .loginProcessingUrl("/doLogin")
//                .usernameParameter("uname")
//                .passwordParameter("pwd")
//                .defaultSuccessUrl("/index.html", true)
//                .failureForwardUrl("/login.html")
                .and()
                .logout()
                .logoutUrl("/logout")
                .and()
                .csrf().disable();

        http.addFilterAt(kaptchaFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
