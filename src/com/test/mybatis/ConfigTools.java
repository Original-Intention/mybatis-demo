package com.test.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigTools {

	public static SqlSessionFactory getSqlSessionFactory(){
        //加配置文件
        InputStream in = null;
		try {
			in = Resources.getResourceAsStream("com/test/resouce/mybatis-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        SqlSessionFactoryBuilder builder= new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
		return factory;		
	}
	
	public static ApplicationContext getApplicationContext(){
		//测试查找用户（id）		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/test/resouce/spring-mybatis.xml");
		return context;		
	}
	
	
}
