package com.accp.work.dao;

import java.util.ArrayList;

import com.accp.work.entity.Tender;

public interface ItenderDao2 {

	//��ȡ����Ͷ����Ϣ
	ArrayList<Tender> getAll();

	//���ָ�����б���Ϣ
	Tender get(int tenderId);

	//ɾ��ָ�����б���Ϣ
	int delete(String tenderId);

}