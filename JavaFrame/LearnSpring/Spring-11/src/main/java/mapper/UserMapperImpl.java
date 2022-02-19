package mapper;

import org.mybatis.spring.SqlSessionTemplate;
import pojo.User;

import java.util.List;

/**
 * @author LYJ
 * @create 2021-06-29 21:39
 */
public class UserMapperImpl implements UserMapper {

    // 我们的所以操作原先都使用sqlSession来执行，现在都是用SqlSessionTemplate
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<User> queryUsers() {

        User user = new User(8, "难过", "shangxin");
        addUser(user);
        deleteUser(user.getId());

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.queryUsers();
    }

    @Override
    public int addUser(User user) {
        return sqlSession.getMapper(UserMapper.class).addUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return sqlSession.getMapper(UserMapper.class).deleteUser(id);
    }
}
