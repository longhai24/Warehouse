package com.accp.t2.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.t2.dao.IPersonDao;
import com.accp.t2.exception.BizException;
import com.accp.t2.pojo.Person;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

//<bean id="personBiz" class="...."/>
@Service
public class PersonBiz {

	@Autowired
	private IPersonDao personDao;

	public PageInfo<Person> findPersonListByPage(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<Person>(personDao.queryAllPersons());
	}

	public void removePersonById(Integer id) {
		personDao.deletePerson(id);
	}

	public Integer addPerson(Person person) {
		if (personDao.loadPersonByName(person.getPname()) != null) {
			throw new BizException(person.getPname() + "重复");
		}
		personDao.savePerson(person);
		return person.getPid();
	}
}
