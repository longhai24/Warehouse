package com.accp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.clazz;
import com.accp.pojo.stu;

public interface IStu {

	//删除学生
	public Integer DelStuByStuId(@Param("did") Integer did);
	//修改学生
	public Integer UpdateStuByStuid(@Param("uid")Integer ustuid,@Param("cid")Integer uclazz);
	//查找指定班级的所有学生
	public clazz SelAllStuByClazz(@Param("cid")Integer cid); 
	//查询某个学生的信息及他班级的信息
	public stu SelSomeStuBystuid(@Param("sid")Integer sid);
}