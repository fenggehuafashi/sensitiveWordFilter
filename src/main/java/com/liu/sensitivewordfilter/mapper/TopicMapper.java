package com.liu.sensitivewordfilter.mapper;

import com.liu.sensitivewordfilter.pojo.Topic;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface TopicMapper {
    public List<Map<String, Object>> queryAllTopic();

    public String queryTopicNameById(BigInteger topicId);
}
