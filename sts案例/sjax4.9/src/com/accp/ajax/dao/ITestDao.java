package com.accp.ajax.dao;

import java.util.ArrayList;

import com.accp.ajax.entity.Department;
import com.accp.ajax.entity.Staff;

public interface ITestDao {

	//��ѯ���в���
	ArrayList<Department> SelectDem();

	//���ݲ��ű�Ų��Ҳ���ְԱ
	ArrayList<Staff> SelectSta(Integer did);

}