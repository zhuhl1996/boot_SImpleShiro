package com.admin.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by zhl on 2021/8/18.
 */
@Configuration
public class ShrioConfig {
    //shrio filter 3
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("manager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
       //设置安全管理器
        bean.setSecurityManager(securityManager);
        /*
        * anon 所有人可以访问
        * authc 必须认证
        * user  '记住我'访问
        * perms 拥有某个资源的权限
        * role  拥有某个角色权限
        * */
        Map<String, String> filterMap = new LinkedHashMap<>();
        //这块和security 是有点不一样的 这边会依次判断 但是security是有一个没权限就会提示没权限
        filterMap.put("/add", "authc");
        filterMap.put("/update", "authc");

        filterMap.put("/add", "perms[1]");
        filterMap.put("/update", "perms[2]");

        bean.setFilterChainDefinitionMap(filterMap);

        //没有认证就跳到login界面
        bean.setLoginUrl("/login");
        //
        bean.setUnauthorizedUrl("/noAuthentication");
        return bean;
    }


    //manager 2
    @Bean
    public DefaultWebSecurityManager manager(@Qualifier("realm") UserRealm realm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联
        securityManager.setRealm(realm);
        return securityManager;
    }

    //realm 1
    @Bean
    public UserRealm realm() {
        return new UserRealm();
    }

    //整合shiro与thymeleaf
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

}
