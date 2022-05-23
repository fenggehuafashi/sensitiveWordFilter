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
    private BigInteger comment_id;
    private BigInteger user_id;
    private BigInteger topic_id;
    private String content;
    private Date date;
}
