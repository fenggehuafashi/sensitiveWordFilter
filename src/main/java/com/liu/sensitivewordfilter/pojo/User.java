package com.liu.sensitivewordfilter.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private BigInteger id;
    private String name;
    private String pwd;
    private Integer level;
    private Integer violation;
}