package com.liu.sensitivewordfilter.controller;

import com.liu.sensitivewordfilter.pojo.Comment;
import com.liu.sensitivewordfilter.pojo.User;
import com.liu.sensitivewordfilter.service.CommentService;
import com.liu.sensitivewordfilter.service.TopicService;
import com.liu.sensitivewordfilter.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @Resource
    UserService userService;

    //根据topic_id查询评论页面
    @RequestMapping("/showComment/{topicId}")
    public String showComment(@PathVariable("topicId") BigInteger topicId, Model model) {
        List<Map<String, Object>> comments = commentService.queryCommentsByTopic(topicId);
//        System.out.println("get>>" + comments);
        String topicName = topicService.queryTopicNameById(topicId);
        model.addAttribute("topicName", topicName);
        model.addAttribute("topicId", topicId);
        model.addAttribute("comments", comments);

        return "/comment/showComment";
    }

    //跳转评论添加页面
    @RequestMapping("/toAddComment/{topicId}")
    public String toAddComment(@PathVariable("topicId") BigInteger topicId, Model model) {
        //查询topicName
        model.addAttribute("topicName", topicService.queryTopicNameById(topicId));
        model.addAttribute("topicId", topicId);

        return "/comment/addComment";
    }


    //添加评论页面
    @PostMapping("/addComment")
    public String addComment(@RequestParam Map<String, Object> params, RedirectAttributes attribdatautes) {
        String content = params.get("content").toString();

        //获取当前用户对象
        Subject currentUser = SecurityUtils.getSubject();
        User user = (User) currentUser.getPrincipal();
        BigInteger userId = user.getId();

        //对评论进行过滤,如果违规次数超过阈值,丢弃评论,提交失败。
        //过滤后违规词会被‘*’替代
//        System.out.println("before filter>>" + content);
        content = commentService.FilterSensiveWord(content, userId);
//        System.out.println("after filter>>" + content);

        //检查是否超过违规次数，如果超过，删除用户权限。
        if (userService.banUser(userId) == 1) {
            System.out.println("违规超过上限>>" + userId);
            //用户踢出
            return "redirect:/logout";
        }


        //检查Comment长度,如果违规检测没通过，会直接返回空字符串。
        if (!commentService.checkCommentLength(content)) {
            //添加失败
            System.out.println("添加评论失败");
            attribdatautes.addFlashAttribute("msg", "false");
            return "redirect:/toAddComment/" + params.get("topic_id").toString();
        }

        //封装Comment
        Comment comment = new Comment();
        comment.setUser_id(userId);
        comment.setTopic_id(new BigInteger(params.get("topic_id").toString()));
        comment.setContent(content);

        //插入Comment
        if (0 != commentService.insertComment(comment)) {
            //添加成功
            System.out.println("成功添加评论");
            return "redirect:/showComment/" + params.get("topic_id").toString();
        }

        //添加失败
        attribdatautes.addFlashAttribute("msg", "false");
        return "redirect:/toAddComment/" + params.get("topic_id").toString();

    }


}
