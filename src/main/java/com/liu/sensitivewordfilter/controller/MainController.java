package com.liu.sensitivewordfilter.controller;


import com.liu.sensitivewordfilter.service.TopicService;

import com.liu.sensitivewordfilter.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;


@Controller
public class MainController {

    @Resource
    TopicService topicService;

    @Resource
    UserService userService;

    //主页
    @RequestMapping({"/", "/index", "index.html"})
    public String toIndex(Model model) {
        model.addAttribute("topics", topicService.queryAllTopic());
        return "index";
    }

    //前往登录页面
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    //登录处理
    @RequestMapping("/login")
    public String login(String userId, String password, Model model, HttpSession session) {
        if (password == null || userId == null) {
            model.addAttribute("msg", "用户名或密码错误！");
            return "login";
        }

        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(userId, password);

        String userName = userService.queryUserById(new BigInteger(userId)).getName();
        try {
            //执行登录方法
            subject.login(token);
            System.out.println(userName + ">>登陆成功，查询所有topic,返回前端展示。");
            //在session中记录用户信息
            session.setAttribute("userId", userId);
            session.setAttribute("userName",userName);

            //返回所以topic信息
            model.addAttribute("topics", topicService.queryAllTopic());
            return "index";
        } catch (UnknownAccountException e) {
            //用户名不存在
            System.out.println("登陆失败");
            model.addAttribute("msg", "用户名或密码错误！");
            return "login";
        } catch (IncorrectCredentialsException e) {
            //密码错误
            System.out.println("登陆失败");
            model.addAttribute("msg", "用户名或密码错误！");
            return "login";
        }
    }


    //注销处理
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        //删除Session
        session.removeAttribute("userName");
        session.removeAttribute("userId");

        //注销
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return "index";
    }


}
