package com.admin.controller.login;

import com.admin.pojo.UserCommen;
import com.admin.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhl on 2021/8/18.
 */
@Controller
public class LoginController {
    @Autowired
    LoginService service;

    @RequestMapping({"/","/index"})
    public String index() {
        return "index";
    }

    @RequestMapping({"/add"})
    public String add() {
        return "add";
    }

    @RequestMapping({"/update"})
    public String update() {
        return "update";
    }

    @RequestMapping({"/login"})
    public String login() {
        return "login";
    }

    @RequestMapping({"/login/{name}"})
    public UserCommen getUser(@PathVariable("name") String name) {
        UserCommen user = service.getUserByName(name);
        return user;
    }

    @RequestMapping("/toLogin")
    public String toLogin(String username, String password) {
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //获取账号密码的token
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //注册
        try {
            subject.login(token);
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("name", username);
            return "index";
        } catch (UnknownAccountException e) {
            System.out.println("用户名不存在");
            //model.mergeAttributes("msg", "用户名不存在");
            return "login";
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码错误");
            return "login";
        }

    }

    @RequestMapping("/noAuthentication")
    @ResponseBody
    public String noAuthentication() {
        return "未授权,请联系管理员";
    }
}
