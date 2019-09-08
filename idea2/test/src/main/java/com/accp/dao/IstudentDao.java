package com.accp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Student;

public interface IstudentDao {
	//查询
	public List<Student> selectClazzAll(@Param("cid") String cid);
	//删除
	public int delete(@Param("sid") String sid);
	//修改
	public int update(@Param("clazz") String clazz, @Param("sid") String sid);
	//查询学生及班级
	public Student selectStudent(@Param("sid") String sid);
}
