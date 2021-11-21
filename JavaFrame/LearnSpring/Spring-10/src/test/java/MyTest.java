import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
    public void selectUsers() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper useMapper = context.getBean("userMapper2", UserMapper.class);
        List<User> users = useMapper.queryUsers();

        for (User user : users) {
            System.out.println(user);
        }
    }
}
