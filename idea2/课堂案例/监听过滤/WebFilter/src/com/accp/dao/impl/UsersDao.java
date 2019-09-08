package com.accp.dao.impl;

import com.accp.dao.IUsersDao;
import com.accp.entity.Users;
import com.accp.util.MD5Signature;

public class UsersDao implements IUsersDao {

	@Override
	public Users loadUsers(String name, String pwd) {
		if ("admin".equals(name) && MD5Signature.md5("123").equals(pwd)) {
			return new Users("admin", MD5Signature.md5("123"));
		} else if ("陈独秀".equals(name) && MD5Signature.md5("456").equals(pwd)) {
			return new Users("陈独秀", MD5Signature.md5("456"));
		} else {
			return null;
		}
	}

}
