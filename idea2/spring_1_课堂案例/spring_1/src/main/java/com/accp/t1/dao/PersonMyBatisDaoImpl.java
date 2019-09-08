package com.accp.t1.dao;


public class PersonMyBatisDaoImpl implements IPersonDao {

	@Override
	public void savePerson() {
		System.out.println("使用MyBatis框架持久化数据");

	}

}
