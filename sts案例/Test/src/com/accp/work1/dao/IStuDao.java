package com.accp.work1.dao;

import java.util.ArrayList;

import com.accp.work1.entity.Stu;
/**
 * 
* <p>Title: IStuDao</p>  
* <p>Description:Dao层接口 </p>  
* @author Apple 

* @date 2019年4月2日
 */
public interface IStuDao {

	ArrayList<Stu> selectAllList();
	
}