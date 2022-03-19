package com.lyj.springboot_jsp_shiro.shiro;

import com.lyj.springboot_jsp_shiro.entity.Perms;
import com.lyj.springboot_jsp_shiro.entity.User;
import com.lyj.springboot_jsp_shiro.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("=================授权================");
        // 获取身份信息
        String principal = (String) principalCollection.getPrimaryPrincipal();

        User user = userService.findRolesByUserName(principal);

        // 根据主身份信息获取角色 和 权限信息

        if (!CollectionUtils.isEmpty(user.getRoles())) {
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            user.getRoles().forEach(role -> {
                simpleAuthorizationInfo.addRole(role.getName()); // 添加角色信息
                // 权限信息
                List<Perms> perms = userService.findPermsByRoleId(role.getId());
                System.out.println("perms: " + perms);
                if (!CollectionUtils.isEmpty(perms) && perms.get(0)!=null) {
                    perms.forEach(perms1 -> {
                        simpleAuthorizationInfo.addStringPermission(perms1.getName());
                    });
                }
            });
            return simpleAuthorizationInfo;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("=================认证================");
        String principal = (String) token.getPrincipal();
        if (principal == null) {
            return null;
        }
        User user = userService.findByUserName(principal);
//        System.out.println(user);
        if (user!=null) {
            return new SimpleAuthenticationInfo(user.getUsername(),
                    user.getPassword(),
                    ByteSource.Util.bytes(user.getSalt()),this.getName());
        }
        return null;
    }
}
