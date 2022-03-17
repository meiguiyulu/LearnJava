import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import realm.customerMd5Realm;

public class testCustomerMd5Realm {
    public static void main(String[] args) {
        //1.创建安全管理器
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();

        //2.注入realm
        customerMd5Realm realm = new customerMd5Realm();

        //3.设置realm使用hash凭证匹配器
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //声明：使用的算法
        credentialsMatcher.setHashAlgorithmName("md5");
        //声明：散列次数
        credentialsMatcher.setHashIterations(1024);
        realm.setCredentialsMatcher(credentialsMatcher);
        defaultSecurityManager.setRealm(realm);

        //4.将安全管理器注入安全工具
        SecurityUtils.setSecurityManager(defaultSecurityManager);

        //5.通过安全工具类获取subject
        Subject subject = SecurityUtils.getSubject();

        //6.认证
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123");

        try {
            subject.login(token);
            System.out.println("登录成功");
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名错误");
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("密码错误");
        }
    }
}
