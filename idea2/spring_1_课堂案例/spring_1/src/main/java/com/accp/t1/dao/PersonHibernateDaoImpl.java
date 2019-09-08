package com.accp.t1.dao;


public class PersonHibernateDaoImpl implements IPersonDao {

	@Override
	public void savePerson() {
		System.out.println("使用Hibernate框架持久化数据");

	}

}
