import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Hello;

/**
 * @author LYJ
 * @create 2021-06-26 17:13
 */
public class MyTest {
    public static void main(String[] args) {
        // 获取Spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.toString());

    }
}
