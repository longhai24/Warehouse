package com.accp.ajax.dao;

import java.util.ArrayList;

import com.accp.ajax.entity.Staff;

public interface IStaffDao {

	// ��ѯ���еķ���
	ArrayList<Staff> SelectAll();

	//����id��ѯ�ķ���
	Staff SelectSome(Integer id);

}