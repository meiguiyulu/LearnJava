import mapper.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.User;

import java.util.List;

/**
 * @author LYJ
 * @create 2021-06-30 9:41
 */
public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper useMapper = context.getBean("userMapper", UserMapper.class);
        List<User> users = useMapper.queryUsers();

        for (User user : users) {
            System.out.println(user);
        }
    }
}
