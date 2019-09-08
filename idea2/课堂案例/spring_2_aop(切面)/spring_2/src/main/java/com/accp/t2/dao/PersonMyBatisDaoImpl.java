package com.accp.t2.dao;

public class PersonMyBatisDaoImpl implements IPersonDao {

	@Override
	public void savePerson() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("使用MyBatis框架添加数据");

	}

	@Override
	public void queryPerson() {
		System.out.println("使用MyBatis框架查询数据");

	}

	@Override
	public void deletePerson() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("使用MyBatis框架移除数据");

	}

}
