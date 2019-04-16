package com.test.mybatis;

import java.util.List;

public interface UserMapper {

	public User findUserById(int id) throws Exception;
	
	public List<User> findUserByName (String username) throws Exception;
	
	public User findUserDetailById(int id);
	
	public void addUser(User user) throws Exception;
	
	/**
	 * @description 批量添加用户
	 * @param users
	 * @throws Exception
	 */
	public void addUsers(List<User> users) throws Exception;
	
	public void deleteUserById(int id) throws Exception;
	
	public void updateUser(User user) throws Exception;

}
