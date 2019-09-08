package com.accp.ajax.biz;

import java.util.ArrayList;

import com.accp.ajax.dao.TestDao;
import com.accp.ajax.entity.Department;
import com.accp.ajax.entity.Staff;

/**
 * 
* <p>Title: TestBiz</p>  
* <p>Description:业务逻辑层 </p>  
* @author Apple 

* @date 2019年4月9日
 */
public class TestBiz {

	TestDao tdao = new TestDao();
	
	//查找所有部门
	public ArrayList<Department> SelectDem(){
		return tdao.SelectDem();
	}
	//根据部门编号查找员工
	public ArrayList<Staff> SelectSta(Integer did){
		return tdao.SelectSta(did);
	}
}
