package com.liu.sensitivewordfilter.mapper;

import com.liu.sensitivewordfilter.pojo.Topic;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
@Mapper
public interface TopicMapper {
    public List<Topic> queryAllTopic();

    public String queryTopicNameById(BigInteger topicId);
}
