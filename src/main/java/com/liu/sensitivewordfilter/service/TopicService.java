package com.liu.sensitivewordfilter.service;

import com.liu.sensitivewordfilter.pojo.Topic;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.List;

public interface TopicService {
    public List<Topic> queryAllTopic() ;

    public String queryTopicNameById(BigInteger topicId);
}
