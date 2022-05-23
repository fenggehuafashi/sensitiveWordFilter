package com.liu.sensitivewordfilter.controller;

import com.liu.sensitivewordfilter.service.CommentService;
import com.liu.sensitivewordfilter.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Controller
public class CommentController {
    @Resource
    CommentService commentService;

    @Resource
    TopicService topicService;

    //进入相应话题的评论页面
    @RequestMapping("/showComment/{topicId}")
    public String showComment(@PathVariable("topicId") BigInteger topicId, Model model) {
        List<Map<String, Object>> comments = commentService.queryCommentsByTopic(topicId);
        System.out.println("get>>"+comments);
        String topicName = topicService.queryTopicNameById(topicId);
        model.addAttribute("topicName", topicName);
        model.addAttribute("comments", comments);
        return "/comment/showComment";
    }


}
