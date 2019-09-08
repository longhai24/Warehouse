package com.accp.t3.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.t3.pojo.Person;

public interface IPersonDao {

	/**
	 * 
	 * @title: queryPerson
	 * @description:查询全部数据
	 * @return
	 */
	public List<Person> queryPerson();

	/**
	 * 
	 * @title: savePerson
	 * @description: 保存
	 * @param person
	 * @return
	 */
	public void savePerson(@Param("person") Person person);

	/**
	 * 
	 * @title: deletePerson
	 * @description: 删除
	 * @param pid
	 * @return
	 */
	public void deletePerson(@Param("pid") Integer pid);

}
