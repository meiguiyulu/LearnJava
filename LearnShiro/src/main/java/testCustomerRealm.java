import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import realm.customerRealm;

/**
 * 测试自定义的Realm
 */
public class testCustomerRealm {
    public static void main(String[] args) {
        DefaultSecurityManager manager = new DefaultSecurityManager();
        manager.setRealm(new customerRealm());
        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123456");
        try {
            subject.login(token);//用户登录
            System.out.println("登录成功~~");
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名错误!!");
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("密码错误!!!");
        }
    }
}
