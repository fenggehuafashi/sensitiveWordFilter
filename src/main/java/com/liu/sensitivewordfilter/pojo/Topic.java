package com.liu.sensitivewordfilter.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topic {
    private BigInteger topic_id;//话题id
    private String topic_name;//话题名字
    private BigInteger creater_id;//创建者id
    private Date create_date;//创建日期
}
