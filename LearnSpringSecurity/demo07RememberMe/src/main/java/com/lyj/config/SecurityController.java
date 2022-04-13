package com.lyj.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
public class SecurityController extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

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
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .rememberMe() // 开启记住我功能
                .tokenRepository(jdbcTokenRepository())// 设置数据库持久化
//                .rememberMeServices(rememberMeServices()) // 指定 rememberMeServices 实现
/*                .rememberMeParameter("remember-me") // 指定接收请求中哪个参数作为开启记住我的参数
                .alwaysRemember(true) // 总是记住我*/
                .and()
                .csrf().disable();
    }

    @Bean
    /*指定数据库持久化*/
    public JdbcTokenRepositoryImpl jdbcTokenRepository(){
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        tokenRepository.setCreateTableOnStartup(true);// 首次启动创建表结构 非首次启动需要设置false
        return tokenRepository;
    }

    /*指定记住我的令牌化实现*/
/*    @Bean
    public RememberMeServices rememberMeServices() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        tokenRepository.setCreateTableOnStartup(true);
        return new PersistentTokenBasedRememberMeServices(UUID.randomUUID().toString(), userDetailsService(), tokenRepository);
    }*/
}
