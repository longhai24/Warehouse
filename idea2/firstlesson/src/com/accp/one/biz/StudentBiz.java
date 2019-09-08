package com.accp.one.biz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.accp.one.dao.StudentDao;
import com.accp.one.entity.StudentEntity;
import com.accp.one.util.StudentUtil;

public class StudentBiz {
	StudentDao dao = new StudentDao();
	/**
	 * 查询所有
	 * @return
	 */
	public ArrayList<StudentEntity> select(){
		
		return dao.select();
		
	}
	/**
	 * 排序
	 * @param name
	 * @return
	 */
	public ArrayList<StudentEntity> up(String name){
		ArrayList<StudentEntity> list = select();
		Collections.sort(list,new StudentUtil(name));
		return list;
	}
	
}
