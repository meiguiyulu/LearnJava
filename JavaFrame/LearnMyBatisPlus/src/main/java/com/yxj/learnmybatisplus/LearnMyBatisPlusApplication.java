package com.yxj.learnmybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.yxj.learnmybatisplus.mapper")  // 扫描mapper文件夹
@SpringBootApplication
public class LearnMyBatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnMyBatisPlusApplication.class, args);
    }

}
