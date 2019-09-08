package com.accp.ajax.dao;

import java.util.ArrayList;

import com.accp.ajax.entity.Staff;

public interface IStaffDao {

	// 查询所有的方法
	ArrayList<Staff> SelectAll();

	//根据id查询的方法
	Staff SelectSome(Integer id);

}