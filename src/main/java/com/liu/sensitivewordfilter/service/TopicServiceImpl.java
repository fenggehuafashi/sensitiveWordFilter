package com.liu.sensitivewordfilter.service;

import com.liu.sensitivewordfilter.mapper.TopicMapper;
import com.liu.sensitivewordfilter.pojo.Topic;
import com.liu.sensitivewordfilter.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicMapper topicMapper;

    @Override
    public List<Map<String,Object>> queryAllTopic() {

        return topicMapper.queryAllTopic();
    }

    @Override
    public String queryTopicNameById(BigInteger topicId) {
        return topicMapper.queryTopicNameById(topicId);
    }
}
