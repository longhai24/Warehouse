package com.accp.work1.dao;

import java.util.ArrayList;

import com.accp.work1.entity.Stu;
/**
 * 
* <p>Title: IStuDao</p>  
* <p>Description:Dao��ӿ� </p>  
* @author Apple 

* @date 2019��4��2��
 */
public interface IStuDao {

	ArrayList<Stu> selectAllList();
	
}