package mapper;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import pojo.User;

import java.util.List;

/**
 * @author LYJ
 * @create 2021-06-30 9:14
 */
public class UserMapper2 extends SqlSessionDaoSupport implements UserMapper {


    @Override
    public List<User> queryUsers() {
        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        return mapper.queryUsers();
    }
}
