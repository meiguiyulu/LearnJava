package dao;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
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

    static Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void getUserById() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void testlog4j() {
        logger.info("info:进入了testlog4j");

        logger.debug("debug:进入了testlog4j");

        logger.error("error:进入了testlog4j");
    }

    @Test
    public void getUserByLimit() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Integer> map = new HashMap<>();
        map.put("startIndex", 3);
        map.put("pageSize", 2);
        List<User> users = mapper.getUserByLimit(map);
        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserByRowBounds() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        // RowBounds实现分页
        RowBounds rowBounds = new RowBounds(0, 3);

        // Java层面实现分页
        List<User> users = sqlSession.selectList("dao.UserMapper.getUserByRowBounds", null, rowBounds);
        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }

}
