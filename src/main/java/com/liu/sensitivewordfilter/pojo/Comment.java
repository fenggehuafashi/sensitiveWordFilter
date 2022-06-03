package com.liu.sensitivewordfilter.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    private BigInteger comment_id;//评论id
    private BigInteger user_id; //用户id
    private BigInteger topic_id;//话题id
    private String content;//评论内容
    private Date date;//评论日期
}
