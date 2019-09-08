package com.accp.t2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.t2.pojo.Address;
import com.accp.t2.pojo.Person;

public interface IPersonDao {

	//命名参数
	public List<Person> queryPersonsByLike(@Param("name") String name);

	public List<Person> queryAllPersonWithAddress();

	public List<Address> queryAllAdressWithPerson();

	public void savePersonWithAddress(@Param("person") Person person);

	public int deletePersonById(@Param("pid") Integer pid);

}
