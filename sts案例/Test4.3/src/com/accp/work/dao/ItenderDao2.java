package com.accp.work.dao;

import java.util.ArrayList;

import com.accp.work.entity.Tender;

public interface ItenderDao2 {

	//获取所有投标信息
	ArrayList<Tender> getAll();

	//获得指定的招标信息
	Tender get(int tenderId);

	//删除指定的招标信息
	int delete(String tenderId);

}