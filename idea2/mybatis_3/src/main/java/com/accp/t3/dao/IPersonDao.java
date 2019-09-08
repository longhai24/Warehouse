package com.accp.t3.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.accp.t3.pojo.Person;

public interface IPersonDao {

	public List<Person> queryAllPersons();

	public List<Person> queryAllPersonsByParam1(@Param("name") String name, @Param("sex") Integer sex);

	public List<Person> queryAllPersonsByParam2(@Param("names") List<String> names);

	public int savePerson(@Param("person") Person person);

	public int updatePerson(@Param("person") Person person);

}
