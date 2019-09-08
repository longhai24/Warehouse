package com.accp.ajax.test;

import java.util.ArrayList;

import com.accp.ajax.biz.StaffBiz;
import com.accp.ajax.entity.StaffEntity;

public class StaffTest {
	public static void main(String[] args) {
		StaffBiz biz = new StaffBiz();
		ArrayList<StaffEntity> list = biz.select("");
		
		for (StaffEntity i : list) {
			System.out.println(i.getName());
		}
	}
}
