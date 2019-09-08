package com.accp.ajax2.biz;

import java.util.ArrayList;

import com.accp.ajax2.dao.SectionDao;
import com.accp.ajax2.entity.SectionEntity;
import com.accp.ajax2.entity.StaffEntity;

public class SectionBiz {
	//创建dao层对象
	SectionDao dao = new SectionDao();
	/**
	 * 查询所有部门集合
	 * @return
	 */
	public ArrayList<SectionEntity> selectCtion(){
		return dao.selectCtion();
	}
	/**
	 * 根据部门id查询该部门的职员
	 * 
	 */
	public ArrayList<StaffEntity> selectStaff(String id){
		return dao.selectStaff(id);
	}
}
