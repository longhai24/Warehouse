package com.accp.t2.dao;

public class PersonHibernateDaoImpl implements IPersonDao {

	@Override
	public void savePerson() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("使用Hibernate框架添加数据");

	}

	@Override
	public void queryPerson() {
		System.out.println("使用Hibernate框架查询数据");
		
	}

	@Override
	public void deletePerson() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("使用Hibernate框架移除数据");
		
	}

}
