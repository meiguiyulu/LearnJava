package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import utils.MyBatisUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LYJ
 * @create 2021-06-22 15:35
 */
public class UserDaoTest {

    @Test
    public void getUserlike() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUserLike("%杰%");
        for (User user : users) {
            System.out.println(user);
            System.out.println("==============================");
        }

        sqlSession.close();
    }


    @Test
    public void test() {
        // 第一步：获得sqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        // 方式一: getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();

        // 方式二：
//        List<User> userList = sqlSession.selectList("dao.UserMapper.getUserList");
        for (User user : userList) {
            System.out.println(user);
        }
        // 关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void getUserById() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void searchUser() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<>();
        map.put("userid", 6);
        map.put("username", "大雨");
        map.put("userpwd", "heavy rain");
        User user = mapper.searchUser(map);
        System.out.println(user);

        sqlSession.close();
    }

    /**
     * 增删改需要提交事务
     */
    @Test
    public void addUser() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int num = mapper.AddUser(new User(5, "苍蓝", "222222"));
        if (num > 0) {
            System.out.println("插入成功");
        }
        // 提交事务
        sqlSession.commit();

        sqlSession.close();
    }


    @Test
    public void InsertUser() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<>();
        map.put("user_id", 6);
        map.put("user_name", "大雨");
        map.put("user_pwd", "heavy rain");

        mapper.InsertUser(map);
        sqlSession.commit();
        sqlSession.close();
    }


    /**
     * 修改用户
     */
    @Test
    public void updateUser() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int num = mapper.UpdateUser(new User(1, "撷思", "xiesi"));
        if (num > 0) {
            System.out.println("修改成功");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 删除用户
     */
    @Test
    public void deleteUser() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int num = mapper.deleteUser(4);
        if (num > 0) {
            System.out.println("删除成功");
        }
        sqlSession.commit();

        sqlSession.close();
    }
}
