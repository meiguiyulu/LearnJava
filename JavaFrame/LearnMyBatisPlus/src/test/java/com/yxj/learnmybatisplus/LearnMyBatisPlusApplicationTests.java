package com.yxj.learnmybatisplus;

import com.yxj.learnmybatisplus.mapper.UserMapper;
import com.yxj.learnmybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LearnMyBatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setName("云杰");
        user.setAge(22);
        user.setEmail("1609226090@qq.com");
        /**
         * 运作下面结果发现：
         *  1、id会帮我们自动生成
         *  2、insert表示受影响的行数
         */
        int insert = userMapper.insert(user);
        System.out.println(insert);
        System.out.println(user);
    }

    // 测试更新
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(1_463_109_181_069_959_169L);
        user.setName("小杰");
        user.setAge(24);
        user.setEmail("1609226090@qq.com");
        int update = userMapper.updateById(user);
        System.out.println(update);
    }

}
