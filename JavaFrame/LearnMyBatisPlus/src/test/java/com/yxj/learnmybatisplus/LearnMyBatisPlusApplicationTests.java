package com.yxj.learnmybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yxj.learnmybatisplus.mapper.UserMapper;
import com.yxj.learnmybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    // 测试乐观锁成功案例
    @Test
    public void SuccessOptimisticLocker(){
        User user = userMapper.selectById(1);
        user.setName("云杰");
        userMapper.updateById(user);
    }

    // 测试乐观锁失败案例
    @Test
    public void FailOptimisticLocker(){
        // 线程1
        User user = userMapper.selectById(1);
        user.setName("刘云杰");

        // 线程2
        User user2 = userMapper.selectById(1);
        user2.setName("云小杰");

        userMapper.updateById(user2);
        userMapper.updateById(user);
    }

    // 查询测试
    @Test
    public void testSelectById(){
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    // 测试批量查询
    @Test
    public void testSelectByBatchId(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }

    // 条件查询map
    @Test
    public void testSelectByMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("name", "刘云杰");
        map.put("age", 22);

        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    // 测试分页查询
    @Test
    public void testPage(){
        // 参数一: 当前页; 参数二: 页面大小
        Page<User> page = new Page<>(1, 5);
        userMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
    }

    // 测试删除
    @Test
    public void testDelete(){
        userMapper.deleteById(2);
        userMapper.deleteBatchIds(Arrays.asList(1_463_109_181_069_959_169L, 1_463_109_181_069_959_170L));
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Jone");
        userMapper.deleteByMap(map);
    }

}
