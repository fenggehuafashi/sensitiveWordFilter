package com.liu.sensitivewordfilter.controller;


import com.hengyi.dzfilter.utils.TextUtils;
import com.liu.sensitivewordfilter.mapper.TopicMapper;
import com.liu.sensitivewordfilter.mapper.UserMapper;
import com.liu.sensitivewordfilter.pojo.Topic;
import com.liu.sensitivewordfilter.pojo.User;
import com.liu.sensitivewordfilter.service.TopicService;
import com.liu.sensitivewordfilter.service.UserService;
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
    UserService userService;

    @Resource
    TopicService topicService;

    //过滤消息
    @RequestMapping(value = "/filter/{content}", produces = "text/html;charset=utf-8")
    @ResponseBody
    public Boolean FilterPage(@PathVariable("content") String content) {
        return TextUtils.existFilter(content);
    }

    //查询用户by id
    @RequestMapping(value = "/user/{id}", produces = "text/html;charset=utf-8")
    public String getuser(@PathVariable("id") BigInteger id, Model model) {
        System.out.println("查询用户id: " + id);
        User user = userService.queryUserById(id);
        System.out.println(user);

        model.addAttribute("msg", user);

        return "index";
    }






}
