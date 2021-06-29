import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;
import service.UserServiceImpl;

/**
 * @author LYJ
 * @create 2021-06-29 17:48
 */
public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 动态代理代理的是接口
        UserService service = context.getBean("userService", UserService.class);

        service.add();
    }
}
