import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import realm.customerMd5Realm;

import java.util.Arrays;

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

        //授权
        if (subject.isAuthenticated()){
            //基于角色权限控制
            System.out.println(subject.hasRole("admin"));
            //基于多角色的权限控制
            System.out.println(subject.hasAllRoles(Arrays.asList("admin", "user")));//true
            System.out.println(subject.hasAllRoles(Arrays.asList("admin", "manager")));//false
            //是否具有其中一个角色
            boolean[] booleans = subject.hasRoles(Arrays.asList("admin", "user", "manager"));
            for (boolean aBoolean : booleans) {
                System.out.println(aBoolean);
            }

            System.out.println("====这是一个分隔符====");

            //基于权限字符串的访问控制  资源标识符：操作：资源类型
            //用户具有的权限 user:*:01  prodect:*
            System.out.println("权限:"+subject.isPermitted("user:update:01"));
            System.out.println("权限:"+subject.isPermitted("prodect:update:02"));

            //分别具有哪些权限
            boolean[] permitted = subject.isPermitted("user:*:01", "user:update:02");
            for (boolean b : permitted) {
                System.out.println(b);
            }

            //同时具有哪些权限
            boolean permittedAll = subject.isPermittedAll("prodect:*:01", "prodect:update:03");
            System.out.println(permittedAll);


        }
    }
}
