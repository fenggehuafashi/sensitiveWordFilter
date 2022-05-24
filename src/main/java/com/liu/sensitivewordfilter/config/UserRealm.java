package com.liu.sensitivewordfilter.config;

import com.liu.sensitivewordfilter.pojo.User;
import com.liu.sensitivewordfilter.service.UserService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    //验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了密码验证");

        UsernamePasswordToken userToken = (UsernamePasswordToken) token;

        //用户名为账号id 必须为数字
        try {
            new BigInteger(userToken.getUsername());
        } catch (NumberFormatException e) {
            //用户名错误
            System.out.println("登陆失败");
            return null;
        }

        //连接数据库 查询用户
        User user = userService.queryUserById(new BigInteger(userToken.getUsername()));

        //没有账号
        if (user == null) {
            //UnKnownAccountException
            return null;
        }

        //密码认证 shiro来做
        //可以加密 md5 md5+salt
        return new SimpleAuthenticationInfo(user, user.getPwd(), "");
    }


    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权");
        //SimpleAuthorizationInfo 还有一个类长得很像，注意区分。
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //拿到当前登录用户对象
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();

        //设置数据库中读取到的权限
        info.addStringPermission(currentUser.getPerms());
//        System.out.println("user:" + currentUser.getName() + "  perms:" + currentUser.getPerms());
        return info;
    }
}
