package com.accp.ajax.biz;

import java.util.ArrayList;

import com.accp.ajax.dao.StaffDao;
import com.accp.ajax.entity.Staff;

/**
 * 
* <p>Title: StaffBiz</p>  
* <p>Description:业务逻辑操作类 </p>  
* @author Apple 

* @date 2019年4月4日
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
