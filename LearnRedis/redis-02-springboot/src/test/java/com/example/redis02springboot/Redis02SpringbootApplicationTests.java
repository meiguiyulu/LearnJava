package com.example.redis02springboot;

import com.example.redis02springboot.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Redis02SpringbootApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("myname", "刘云杰");
        System.out.println(redisTemplate.opsForValue().get("myname"));
    }
    @Test
    void myTest() throws JsonProcessingException {
        User user = new User("云杰", 23);
        /**
         * String value = new ObjectMapper().writeValueAsString(user);
         * redisTemplate.opsForValue().set("user", value);
         *
         * {"name":"云杰","age":23}
         */
        redisTemplate.opsForValue().set("user", user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

}
