package com.liu.sensitivewordfilter.service;

import com.liu.sensitivewordfilter.pojo.Topic;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface TopicService {
    public List<Map<String,Object>> queryAllTopic() ;

    public String queryTopicNameById(BigInteger topicId);
}
