package com.accp.biz;

import com.accp.dao.IUsersDao;
import com.accp.dao.impl.UsersDao;
import com.accp.entity.Users;

public class UsersBiz {
	private IUsersDao usersDao = new UsersDao();

	/**
	 * 
	 * @title: getUsers
	 * @description: 根据用户名或者查询出指定用户信息
	 * @param name
	 * @param pwd
	 * @return
	 */
	public Users getUsers(String name, String pwd) {
		return usersDao.loadUsers(name, pwd);
	}
}
