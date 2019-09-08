package com.accp.ajax.dao;

import java.util.ArrayList;

import com.accp.ajax.entity.Department;
import com.accp.ajax.entity.Staff;

public interface ITestDao {

	//查询所有部门
	ArrayList<Department> SelectDem();

	//根据部门编号查找部门职员
	ArrayList<Staff> SelectSta(Integer did);

}