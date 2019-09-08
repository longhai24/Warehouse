package com.accp.t2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.t2.pojo.Person;

public interface IPersonDao {

	public List<Person> queryAllPersons();

	public int deletePerson(@Param("id") Integer id);

	public int savePerson(@Param("person") Person person);
	
	public Person loadPersonByName(@Param("name") String name);

}
