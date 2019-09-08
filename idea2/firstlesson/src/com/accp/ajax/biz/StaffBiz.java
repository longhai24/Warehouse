package com.accp.ajax.biz;

import java.util.ArrayList;

import com.accp.ajax.dao.StaffDao;
import com.accp.ajax.entity.StaffEntity;

public class StaffBiz {
	StaffDao dao = new StaffDao();
	public ArrayList<StaffEntity> select(String na){
		return dao.select(na);
	}
}	
