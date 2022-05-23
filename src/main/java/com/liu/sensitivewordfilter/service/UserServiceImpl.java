package com.liu.sensitivewordfilter.service;

import com.liu.sensitivewordfilter.mapper.UserMapper;
import com.liu.sensitivewordfilter.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public User queryUserById(BigInteger id) {
        return userMapper.queryUserById(id);
    }
}
