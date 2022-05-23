package com.liu.sensitivewordfilter.controller;


import com.hengyi.dzfilter.utils.TextUtils;
import com.liu.sensitivewordfilter.mapper.TopicMapper;
import com.liu.sensitivewordfilter.mapper.UserMapper;
import com.liu.sensitivewordfilter.pojo.Topic;
import com.liu.sensitivewordfilter.pojo.User;
import com.liu.sensitivewordfilter.service.TopicService;
import com.liu.sensitivewordfilter.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.jws.WebParam;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.Collection;
import java.util.List;

@Controller
public class MainController {

    @Resource
    TopicService topicService;

    @RequestMapping({"/", "/index", "index.html"})
    public String toIndex(Model model) {
        model.addAttribute("msg", "welcome!!!");

        return "index";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(String username, String password, Model model) {
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            //执行登录方法
            subject.login(token);
            System.out.println(username + ">>登陆成功，查询所有topic,返回前端展示。");
            model.addAttribute("topics", topicService.queryAllTopic());
            return "index";
        } catch (UnknownAccountException e) {
            //用户名不存在
            model.addAttribute("msg", "用户名或密码错误！");
            return "login";
        } catch (IncorrectCredentialsException e) {
            //密码错误
            model.addAttribute("msg", "用户名或密码错误！");
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();

        return "index";
    }


}
