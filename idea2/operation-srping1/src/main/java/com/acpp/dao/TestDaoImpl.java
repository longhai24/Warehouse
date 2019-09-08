package com.acpp.dao;

public class TestDaoImpl implements TestDao{

	@Override
	public void save() {
		System.out.println("新增持久化操作");
		
	}

	@Override
	public void delete() {
		System.out.println("删除操作");
	}
	
}
