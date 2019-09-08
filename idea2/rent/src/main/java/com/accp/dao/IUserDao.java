package com.accp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.user;

public interface IUserDao {
	//查询
	public List<user> findUsers();
	//添加
	public int addUser(@Param("u") user u);
	//登陆
	public user findUser(@Param("name") String name,@Param("pwd") String pwd);
}
