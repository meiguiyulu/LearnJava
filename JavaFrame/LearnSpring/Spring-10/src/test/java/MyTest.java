import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import utils.MyBatisUtils;

import java.util.List;

/**
 * @author LYJ
 * @create 2021-06-29 20:33
 */
public class MyTest {
    public static void main(String[] args) {
    }
    @Test
    public void selectUsers(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.queryUsers();
        for (User user: users){
            System.out.println(user);
        }

        sqlSession.close();
    }
}
