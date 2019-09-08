package com.accp.ajax.test;

import java.util.ArrayList;

import com.accp.ajax.dao.StaffDao;
import com.accp.ajax.entity.Staff;

public class StaffTest {

	/**
	 * 
	 * <p>
	 * Title: main
	 * </p>
	 * <p>
	 * Description:≤‚ ‘¿‡
	 * </p>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaffDao sd = new StaffDao();
		ArrayList<Staff> li = sd.SelectAll();
		for (Staff string1 : li) {
			System.out.println(string1);
		}
	}

}
