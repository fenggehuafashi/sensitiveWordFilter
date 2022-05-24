package com.liu.sensitivewordfilter.service;

import com.liu.sensitivewordfilter.pojo.Comment;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface CommentService {
    public List<Map<String, Object>> queryCommentsByTopic(BigInteger TopicId);

    public BigInteger countComment(BigInteger TopicId);

    public int insertComment(Comment comment);

    public boolean checkCommentLength(String s);
}
