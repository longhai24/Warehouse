package com.accp.t3.biz;



import org.springframework.beans.factory.annotation.Autowired;

import com.accp.t3.dao.IPersonDao;
import com.accp.t3.pojo.Person;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class PersonBiz {

	//自动类型注入
	@Autowired
	private IPersonDao personDao;

	public PageInfo<Person> findPersonListByPage(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<Person>(personDao.queryAllPersons());
	}

	public Person getPersonById(Integer id) {
		return personDao.loadPerson(id);
	}

	public void removePersonById(Integer id) {
		personDao.deletePerson(id);
	}
}
