package com.accp.t3.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.t3.pojo.Person;


public interface IPersonDao {

	public List<Person> queryAllPersons();

	public Person loadPerson(@Param("id") Integer id);

	public int deletePerson(@Param("id") Integer id);

}
