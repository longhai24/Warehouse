package com.accp.ajax.test;

import java.util.ArrayList;

import com.accp.ajax.dao.TestDao;
import com.accp.ajax.entity.Department;
import com.accp.ajax.entity.Staff;
import com.alibaba.fastjson.JSON;

public class Test {

	
	/**
	 * 
	 * <p>Title: main</p>  
	 * <p>Description:≤‚ ‘¿‡ </p>  
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestDao td = new TestDao();
		ArrayList<Department> list  = td.SelectDem();
		ArrayList<Staff> list2 = td.SelectSta(1);
		for (Staff a : list2) {
			String p = JSON.toJSONString(list2);
			System.out.println(p);
		}
	}

}
