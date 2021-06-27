import dao.UseDaoImpl;
import dao.UseDaoMySQLImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UseServiceImpl;

/**
 * @author LYJ
 * @create 2021-06-26 14:30
 */
public class MyTest {
    public static void main(String[] args) {
//        // 用户调用的是业务层，dao层不需要接触
//        UseServiceImpl useService = new UseServiceImpl();
//
//        useService.setUseDao(new UseDaoMySQLImpl());
//        useService.getUser();

        // 获取ApplicationContext：拿到Spring的容器
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        UseServiceImpl useServiceImpl = (UseServiceImpl) context.getBean("useServiceImpl");
        useServiceImpl.getUser();
    }
}
