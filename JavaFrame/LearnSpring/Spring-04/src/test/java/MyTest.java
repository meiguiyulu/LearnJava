import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Student;
import pojo.User;

/**
 * @author LYJ
 * @create 2021-06-27 20:28
 */
public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) context.getBean("student");

        System.out.println(student.toString());

        /**
         *   Student{name='刘云杰', address=Address{address='山东临朐'}, books=[红楼梦, 西游记, 水浒传, 三国演义]
         * , hobby=[足球, 篮球, 电影, 代码], card={身份证=333333333333333333, 手机号=11111111111}
         * , game=[王者荣耀, LOL], wife='null', info='{学号=2019532088, 性别=男}'}
         */
    }

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
        User user = context.getBean("user2", User.class);

        System.out.println(user);
    }
}
