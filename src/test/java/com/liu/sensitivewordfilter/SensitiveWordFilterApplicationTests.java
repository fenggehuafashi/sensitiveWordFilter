package com.liu.sensitivewordfilter;

import com.hengyi.dzfilter.utils.TextUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.Map;
import java.util.Scanner;

@SpringBootTest
class SensitiveWordFilterApplicationTests {

    @Test
    void contextLoads() {
        String line = "";

        String[] after = line.split("[\\n]");
//		for (int i = 0; i < after.length; i++) {
//			System.out.print(after[i]);
//		}

        //扩充词库
        for (int i = 0; i < after.length; i++) {
            TextUtils.addFilter(after[i]);
        }

    }

}
