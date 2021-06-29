import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.Animal;

/**
 * @author LYJ
 * @create 2021-06-29 19:42
 */
public class animalTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Animal dog = context.getBean("dog", Animal.class);

        dog.bark();
    }
}
