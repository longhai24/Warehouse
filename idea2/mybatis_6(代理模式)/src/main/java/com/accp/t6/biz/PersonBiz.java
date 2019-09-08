package com.accp.t6.biz;

import java.util.List;

import com.accp.t6.dao.IPersonDao;
import com.accp.t6.pojo.Person;
import com.accp.t6.util.SqlSessionUtil;

public class PersonBiz {

	public List<Person> findPersonList() {
		IPersonDao dao = SqlSessionUtil.getSession().getMapper(IPersonDao.class);
		return dao.queryAllPersons();
	}

	// 非常重要
	public void addPerson(Person person) {
		IPersonDao dao = SqlSessionUtil.getSession().getMapper(IPersonDao.class);
		dao.savePerson(person);
	}

	// 非常重要
	public void removePerson(Integer pid) {
	}

	// 非常重要
	public void modifyPerson(Person person) {
	}

}
