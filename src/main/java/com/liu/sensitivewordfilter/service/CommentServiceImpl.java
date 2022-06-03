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

    @Override
    public int deleteComment(BigInteger commentId) {
        return commentMapper.deleteComment(commentId);
    }

    /**
     * 敏感词过滤业务代码
     *
     * @param content
     * @return
     */
    @Override
    public String FilterSensiveWord(String content, BigInteger userID) {
        //调用DFA算法，对评论内容进行过滤，敏感词将被替换为'*'号
        content = TextUtils.filter(content);
        //敏感词和违规词的字符数记录
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

        //如果敏感词或违规词的字符数超过设定的阈值，则判定该条评论违规，用户违规次数+1。
        if (star / length >= CommentAbuseJudgeThreshold) {
            userService.addViolationCount(userID);
            return "";
        }
        //判定不违规可以提交，返回过滤后的内容。
        return content;
    }
}
