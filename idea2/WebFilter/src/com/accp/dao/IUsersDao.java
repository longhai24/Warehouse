package com.accp.dao;

import com.accp.entity.Users;

public interface IUsersDao {
	/**
	 * 
	 * @title: loadUsers
	 * @description: 根据用户名和密码读取用户信息
	 * @param name
	 * @param pwd
	 * @return
	 */
	public Users loadUsers(String name, String pwd);
}
