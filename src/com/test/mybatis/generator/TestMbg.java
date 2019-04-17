package com.test.mybatis.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class TestMbg {

    public void generator() throws Exception{
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("C:\\Users\\zwh\\eclipse-workspace\\mybatis-demo\\src\\com\\test\\resouce\\generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
    public static void main(String[] args) {
    	try {
    		TestMbg generatorSqlmap = new TestMbg();
			generatorSqlmap.generator();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
}
