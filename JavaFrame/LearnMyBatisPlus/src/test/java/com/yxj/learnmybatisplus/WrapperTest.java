package com.yxj.learnmybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yxj.learnmybatisplus.mapper.UserMapper;
import com.yxj.learnmybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class WrapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("name")  // name不为空
                .isNotNull("email")// email不为空
                .ge("age", 12);// 年龄大于12
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    void test2(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // 查询名字是云杰的
        wrapper.eq("name", "云杰");
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    @Test
    void test3(){

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // 查询年龄在20到30之间的用户
        wrapper.between("age", 20, 30);
        List<User> user = userMapper.selectList(wrapper);
        user.forEach(System.out::println);
    }

    // 模糊查询
    @Test
    void test4(){

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // 查询姓名中不包含n的 email为1开头的
        wrapper
                .notLike("name", "n")
                .likeRight("email", '1');  // '1%'
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    // 通过id进行排序
    @Test
    void test5(){

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

}
