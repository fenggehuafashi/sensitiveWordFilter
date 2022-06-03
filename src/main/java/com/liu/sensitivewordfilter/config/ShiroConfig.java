package com.liu.sensitivewordfilter.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultSecurityManager defaultSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultSecurityManager);

        //添加shiro内置过滤器
        /*
         *  anon: 无需认证就可访问
         *  authc: 必须认证才能访问
         *  user: 必须拥有记住我功能才能访问
         *  role: 拥有某个角色权限才能访问
         * */
        //拦截记录集合，以键值对的形式记录
        Map<String, String> filterMap = new LinkedHashMap<>();
        //权限设置,根目录不拦截
        filterMap.put("/", "anon");
        filterMap.put("/index", "anon");
        filterMap.put("/index.html", "anon");
        filterMap.put("/toLogin", "anon");
        filterMap.put("/login", "anon");
        //静态资源放行
        filterMap.put("/img/**", "anon");
        filterMap.put("/css/**", "anon");
        filterMap.put("/js/**", "anon");

        //进入评论页面需要用户权限，被ban的用户无法访问。
        filterMap.put("/addComment/*", "perms[user:allow]");
        //其他页面拦截。
        filterMap.put("/**", "authc");
        bean.setFilterChainDefinitionMap(filterMap);

        //设置登录页面的Controller URL
        bean.setLoginUrl("/toLogin");
        //未授权提示页面,访问未授权页面时，将会被安全框架拦截后返回首页。
        bean.setUnauthorizedUrl("/index");
        return bean;
    }


    //DefaultWebSecurityManager
    @Bean(name = "securityManager")
    public DefaultSecurityManager getDefaultSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager SecurityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        SecurityManager.setRealm(userRealm);

        return SecurityManager;
    }

    //创建Realm 对象,需要自定义.
    @Bean(name = "userRealm")
    public UserRealm userRealm() {
        return new UserRealm();
    }

    //整合ShiroDialect,shiro and Thymeleaf
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }

}
