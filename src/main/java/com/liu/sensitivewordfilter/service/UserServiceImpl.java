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

    static Integer violationLimitCount = 10;


    @Override
    public User queryUserById(BigInteger id) {
        return userMapper.queryUserById(id);
    }


    /**
     * 检查用户违规次数,如果超过violationLimitCount。
     * 删除用户权限
     *
     * @param id
     * @return
     */
    @Override
    public int banUser(BigInteger id) {

        if (queryViolationCount(id) >= 10) {
            userMapper.banUser(id);
            return 1;
        }

        return 0;
    }

    @Override
    public int addViolationCount(BigInteger id) {
        return userMapper.addViolationCount(id);
    }

    @Override
    public int queryViolationCount(BigInteger id) {
        return userMapper.queryViolationCount(id);
    }
}
