package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import utils.MyBatisUtils;

import java.util.List;

/**
 * @author LYJ
 * @create 2021-06-22 15:35
 */
public class UserDaoTest {

    @Test
    public void getUserLike(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

}
