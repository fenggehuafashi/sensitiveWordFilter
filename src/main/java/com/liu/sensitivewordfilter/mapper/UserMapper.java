package com.liu.sensitivewordfilter.mapper;

import com.liu.sensitivewordfilter.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;


@Repository
@Mapper
public interface UserMapper {
    public User queryUserById(BigInteger id);

}
