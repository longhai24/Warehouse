package com.accp.ajax.biz;

import java.util.ArrayList;

import com.accp.ajax.dao.TestDao;
import com.accp.ajax.entity.Department;
import com.accp.ajax.entity.Staff;

/**
 * 
* <p>Title: TestBiz</p>  
* <p>Description:ҵ���߼��� </p>  
* @author Apple 

* @date 2019��4��9��
 */
public class TestBiz {

	TestDao tdao = new TestDao();
	
	//�������в���
	public ArrayList<Department> SelectDem(){
		return tdao.SelectDem();
	}
	//���ݲ��ű�Ų���Ա��
	public ArrayList<Staff> SelectSta(Integer did){
		return tdao.SelectSta(did);
	}
}
