import config.javaConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pojo.User;

/**
 * @author LYJ
 * @create 2021-06-29 9:57
 */
public class MyTest {
    public static void main(String[] args) {
        // 如果完全使用了配置类方式去做，我们可以通过AnnotationConfigApplicationContext获取上下文容器
        // 通过配置类的class对象加载
        ApplicationContext context = new AnnotationConfigApplicationContext(javaConfig.class);
        User getUser = (User) context.getBean("getUser");

        System.out.println(getUser.getName());
    }
}
