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
    private BigInteger topic_id;
    private String topic_name;
    private BigInteger creater_id;
    private Date create_date;
}
