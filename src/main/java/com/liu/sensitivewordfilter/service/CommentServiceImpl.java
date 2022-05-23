package com.liu.sensitivewordfilter.service;

import com.liu.sensitivewordfilter.mapper.CommentMapper;
import com.liu.sensitivewordfilter.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

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
}
