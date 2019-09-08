package com.accp.t1.biz;

import com.accp.t1.dao.IPersonDao;
import com.accp.t1.dao.PersonMyBatisDaoImpl;

public class PersonBiz {

	private IPersonDao personDao;
	


	public IPersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(IPersonDao personDao) {
		this.personDao = personDao;
	}

	public PersonBiz() {
		super();
	}

	public void addPerson() {
		System.out.println("实现新增会员业务");
		personDao.savePerson();
	}


}
