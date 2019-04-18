package com.test.mybatis;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

public class SpringWithMybatisTests {

	public static ApplicationContext context = ConfigTools.getApplicationContext();
	@Test
	public void test() throws Exception {
        UserMapper usermapper = (UserMapper) context.getBean("userMapper");
        User user = usermapper.findUserById(1);
        System.out.println(user); 
	}
}
