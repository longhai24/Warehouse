package com.accp.ajax.biz;

import java.util.ArrayList;

import com.accp.ajax.dao.StaffDao;
import com.accp.ajax.entity.Staff;

/**
 * 
* <p>Title: StaffBiz</p>  
* <p>Description:ҵ���߼������� </p>  
* @author Apple 

* @date 2019��4��4��
 */
public class StaffBiz {

	StaffDao sd = new StaffDao();
	public Staff SelectSome(Integer id) {
		return sd.SelectSome(id);
	}
	public ArrayList<Staff> SelectAll(){
		return sd.SelectAll();
	}
}
