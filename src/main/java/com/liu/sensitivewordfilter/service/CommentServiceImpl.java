package com.liu.sensitivewordfilter.service;

import com.hengyi.dzfilter.utils.TextUtils;
import com.liu.sensitivewordfilter.mapper.CommentMapper;
import com.liu.sensitivewordfilter.mapper.UserMapper;
import com.liu.sensitivewordfilter.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Autowired
    UserService userService;

    static Integer CommentLengthLimit = 1000;
    static Double CommentAbuseJudgeThreshold = 0.1;

    @Override
    public List<Map<String, Object>> queryCommentsByTopic(BigInteger TopicId) {
        return commentMapper.queryCommentsByTopic(TopicId);
    }

    @Override
    public BigInteger countComment(BigInteger TopicId) {
        return commentMapper.countComment(TopicId);
    }

    @Override
    public int insertComment(Comment comment) {
        return commentMapper.insertComment(comment);
    }

    @Override
    public boolean checkCommentLength(String s) {
        boolean judge = true;
        if (s.length() > CommentLengthLimit) {
            System.out.println("comment over size!");
            judge = false;
        }
        if (s.length() == 0) {
            System.out.println("comment is empty!");
            judge = false;
        }

        System.out.println("content length judge>>" + judge);
        return judge;
    }

    /**
     * 敏感词过滤
     * @param content
     * @return
     */
    @Override
    public String FilterSensiveWord(String content,BigInteger userID) {
        content = TextUtils.filter(content);

        double star = 0.0;
        double length = content.length();
        // 根据指定的字符构建正则
        Pattern pattern = Pattern.compile("\\*");
        // 构建字符串和正则的匹配
        Matcher matcher = pattern.matcher(content);
        // 循环依次往下匹配
        while (matcher.find()) {
            // 如果匹配,则数量+1
            star++;
        }

        if (star / length >= CommentAbuseJudgeThreshold) {
            userService.addViolationCount(userID);
            return "";
        }

        return content;
    }
}
