package com.liu.sensitivewordfilter.mapper;

import com.liu.sensitivewordfilter.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface CommentMapper {
    public List<Map<String, Object>> queryCommentsByTopic(BigInteger TopicId);

    public BigInteger countComment(BigInteger TopicId);

    public int insertComment(Comment comment);
}
