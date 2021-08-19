package com.admin.config;

import com.admin.pojo.UserCommen;
import com.admin.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zhl on 2021/8/18.
 */
//自定义realm
public class UserRealm extends AuthorizingRealm {
    @Autowired
    LoginService loginService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("===============>授权");
        SimpleAuthorizationInfo zationInfo = new SimpleAuthorizationInfo();

        //zationInfo.addStringPermission("1");
        //获取当前用户对象进行权限判定
        Subject subject = SecurityUtils.getSubject();
        UserCommen user = (UserCommen)subject.getPrincipal();
        //zationInfo.addObjectPermissions();  多权限
        zationInfo.addStringPermission(user.getRole());
        return zationInfo;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("===============>认证");
        //controller 注册成功后 authenticationToken全局通用
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        //取用户名密码
        UserCommen user = loginService.getUserByName(token.getUsername());
        if (user == null) {
            //UnknownAccountException
            return null;
        }

        return new SimpleAuthenticationInfo(user, user.getPass(),"");
    }
}
