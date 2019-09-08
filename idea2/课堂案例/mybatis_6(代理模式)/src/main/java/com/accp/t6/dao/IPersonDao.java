package com.accp.t6.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.t6.pojo.Person;

public interface IPersonDao {

	public List<Person> queryAllPersons();

	public int savePerson(@Param("person") Person person);

}
