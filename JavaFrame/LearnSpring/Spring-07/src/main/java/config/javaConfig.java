package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pojo.User;

/**
 * @author LYJ
 * @create 2021-06-29 9:55
 */

/**
 * @Configuration代表这是一个配置类，等价于之前的beans.xml配置文件
 */
@Configuration
@ComponentScan("pojo")
@Import(UserConfig.class)
public class javaConfig {

    /**
     * 注册一个bean，相当于之前的bean标签
     * 这个方法的名字，相当于bean标签的id属性
     * 这个方法返回值，相当于bean标签的class属性
     * @return
     */
    @Bean
    public User getUser(){
        // 返回要注入到bean的对象
        return new User();
    }

}
