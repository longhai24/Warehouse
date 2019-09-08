package com.accp.t2.biz;

import com.accp.t2.dao.IPersonDao;

public class PersonBiz {

	private IPersonDao personDao;

	//连接点(Join Point)
	public IPersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(IPersonDao personDao) {
		this.personDao = personDao;
	}

	public void addPerson() {
		System.out.println("实现新增会员业务");
		personDao.savePerson();
	}

	public void findPerson() {
		System.out.println("实现查询会员业务");
		personDao.queryPerson();
	}

	public void removePerson() {
		System.out.println("实现移除会员业务");
		personDao.deletePerson();
	}

}
