package com.test.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ConfigTools {

	public static SqlSessionFactory getSqlSessionFactory(){
        //º”≈‰÷√Œƒº˛
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
}
