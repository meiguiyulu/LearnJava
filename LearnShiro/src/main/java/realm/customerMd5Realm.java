package realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * 使用自定义realm 加入md5 + salt +hash
 */
public class customerMd5Realm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获取用户信息
        String principal = (String) authenticationToken.getPrincipal();
        //假设这是从数据库查询到的信息
        String username="zhangsan";
        String password="7268f6d32ec8d6f4c305ae92395b00e8";//加密后

        //根据用户名查询数据库
        if (username.equals(principal)) {
            //参数1:数据库用户名
            //参数2:数据库md5+salt之后的密码
            //参数3:注册时的随机盐
            //参数4:realm的名字
            return new SimpleAuthenticationInfo(principal,
                    password,
                    ByteSource.Util.bytes("@#$*&QU7O0!"),
                    this.getName());
        }
        return null;
    }
}
