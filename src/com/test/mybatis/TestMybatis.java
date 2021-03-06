package com.test.mybatis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.mybatis.dao.OrdersMapper;
import com.test.mybatis.javabean.Orders;

public class TestMybatis {
	
	public static SqlSessionFactory factory = ConfigTools.getSqlSessionFactory();
	public static ApplicationContext context = ConfigTools.getApplicationContext();
	
	@Test
	public void findUserById() throws Exception {
		//测试查找用户（id）
		SqlSession sqlSession=factory.openSession();        
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        User user = usermapper.findUserById(1);
        System.out.println(user);
        sqlSession.close();        
	}
	
	
	@Test
	public void springFindUserById() throws Exception {             
        UserMapper usermapper = context.getBean(UserMapper.class);
        User user = usermapper.findUserById(1);
        System.out.println(user);      
	}
	
	@Test
	public void findUserByName() throws Exception {
		//测试查找用户（username）
        SqlSession sqlSession=factory.openSession(); 
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = usermapper.findUserByName("京东快递员");
        //循环打印user
        for(User user : users) {
        	System.out.println(user);
        }
        sqlSession.close();
	}
	
	@Test
	public void findUserDetailById() throws Exception {
		//测试查找用户（一对一关联查询）
        SqlSession sqlSession=factory.openSession(); 
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        User user = usermapper.findUserDetailById(85);
        //打印user
        System.out.println(user);
        sqlSession.close();
	}	
	
	@Test
	public void findUserOrderDetailById() throws Exception {
		//测试查找用户（一对多关联查询、多对多查询）
        SqlSession sqlSession=factory.openSession(); 
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> orders = ordersMapper.findOrderUserDetailById(3);
        //循环打印user
        for(Orders order : orders) {
        	System.out.println(order);
        }
        sqlSession.close();
	}
	
	@Test
	public void addUser() throws Exception {
		//测试添加用户
        SqlSession sqlSession=factory.openSession(); 
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setAddress("中国北京市朝阳区北辰西路8号北辰世纪中心A座");
        user.setBirthday(new Date());
        user.setCustom_id("003");
        user.setSex("男");
        user.setUsername("京东快递员");
        usermapper.addUser(user);
        sqlSession.commit();
        
        List<User> users = usermapper.findUserByName("京东快递员");
        //循环打印user
        for(User us : users) {
        	System.out.println(us);
        }
        sqlSession.close();
	}
	
	@Test
	public void addUsers() throws Exception {
		//	测试批量添加用户
        SqlSession sqlSession=factory.openSession(); 
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = new ArrayList<User>();
        User user = new User();
        User user1 = new User();
        
        user.setAddress("北京海淀区中关村软件园二期百度科技园");
        user.setBirthday(new Date());
        user.setCustom_id("007");
        user.setSex("男");
        user.setUsername("百度推广员");
        
        user1.setAddress("北京市朝阳区望京东路6号 望京国际研发园三期");
        user1.setBirthday(new Date());
        user1.setCustom_id("005");
        user1.setSex("男");
        user1.setUsername("美团外卖员");
        
        list.add(user1);
        list.add(user);
        usermapper.addUsers(list);
        sqlSession.commit();
        sqlSession.close();
	}
	
	
	@Test
	public void deleteUser() throws Exception {
		//测试删除用户
        SqlSession sqlSession=factory.openSession(); 
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        usermapper.deleteUserById(88);
        sqlSession.commit();
        
        User user = usermapper.findUserById(88);
        System.out.println(user);
        sqlSession.close();
	}
	
	@Test
	public void updateUser() throws Exception {
		//测试更新用户
        SqlSession sqlSession=factory.openSession(); 
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
       
        User user = new User();
        user.setId(85);
        user.setAddress("北京市北四环西路58号理想国际大厦20层");
        user.setCustom_id("004");
        user.setUsername("新浪程序员");
        usermapper.updateUser(user);
        sqlSession.commit();
        
        User us = usermapper.findUserById(85);
        System.out.println(us);
        sqlSession.close();
	}
	
	@Test
	public void testCache1() throws Exception {
		//测试一级缓存
		SqlSession sqlSession=factory.openSession(); 
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        User user1 = usermapper.findUserById(85);        
        usermapper.updateUser(user1);
        sqlSession.commit();
        User user2 = usermapper.findUserById(85);       
        System.out.println(user1);
        System.out.println(user2);
        sqlSession.close();
	}
	
	@Test
	public void testCache2() throws Exception {
		//测试二级缓存
		SqlSession sqlSession1=factory.openSession();
		SqlSession sqlSession2=factory.openSession();
        UserMapper usermapper1 = sqlSession1.getMapper(UserMapper.class);
        User user1 = usermapper1.findUserById(85);
        System.out.println(user1);
        sqlSession1.close();
        UserMapper usermapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = usermapper2.findUserById(85);       
        System.out.println(user2);
        sqlSession2.close();
	}
	
}
