package com.liu.sensitivewordfilter;

import com.hengyi.dzfilter.utils.TextUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SensitiveWordFilterApplicationTests {

	@Test
	void contextLoads() {
		String text = "fuck you bitch,邓小平";

		System.out.println(TextUtils.filter(text));

	}

}
