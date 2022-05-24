package com.liu.sensitivewordfilter.controller;


import com.liu.sensitivewordfilter.service.TopicService;

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


@Controller
public class MainController {

    @Resource
    TopicService topicService;

    //主页
    @RequestMapping({"/", "/index", "index.html"})
    public String toIndex(Model model) {
        model.addAttribute("msg", "welcome!!!");

        return "index";
    }

    //前往登录页面
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    //登录处理
    @RequestMapping("/login")
    public String login(String username, String password, Model model, HttpSession session) {
        if (password == null || username == null) {
            model.addAttribute("msg", "用户名或密码错误！");
            return "login";
        }

        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            //执行登录方法
            subject.login(token);
            System.out.println(username + ">>登陆成功，查询所有topic,返回前端展示。");
            session.setAttribute("userName", username);
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
        session.removeAttribute("userName");
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return "index";
    }


}
