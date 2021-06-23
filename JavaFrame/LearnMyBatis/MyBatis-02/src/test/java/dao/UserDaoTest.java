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
    public void getUserLike(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUserLike("%杰%");
        for (User user:users){
            System.out.println(user);
            System.out.println("=========================");
        }

        sqlSession.close();
    }

}
