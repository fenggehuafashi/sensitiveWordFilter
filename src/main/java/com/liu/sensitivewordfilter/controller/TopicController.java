package com.liu.sensitivewordfilter.controller;

import com.liu.sensitivewordfilter.pojo.Topic;
import com.liu.sensitivewordfilter.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class TopicController {
    @Resource
    TopicService topicService;

    //查询所有Topic
    @RequestMapping(value = "/topic", produces = "text/html;charset=utf-8")
    public String queryAllTopic(Model model)  {
        System.out.println("查询所有topic");
        //封装Topic后返回给前端页面展示
        model.addAttribute("topics", topicService.queryAllTopic());
        return "index";
    }
}
