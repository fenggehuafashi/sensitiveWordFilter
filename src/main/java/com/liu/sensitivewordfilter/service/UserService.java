package com.liu.sensitivewordfilter.service;

import com.liu.sensitivewordfilter.pojo.User;

import java.math.BigInteger;

public interface UserService {
    public User queryUserById(BigInteger id);

    public int banUser(BigInteger id);

    public int addViolationCount(BigInteger id);

    public int queryViolationCount(BigInteger id);

}
