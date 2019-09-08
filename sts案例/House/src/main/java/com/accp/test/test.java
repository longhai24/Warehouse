package com.accp.test;

import java.util.List;

import org.junit.Test;

import com.accp.biz.HouseBiz;
import com.accp.dao.IHouse;
import com.accp.pojo.HouseIo;
import com.accp.pojo.User;
import com.accp.util.CgLibTransProxyUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


public class test {

	@Test
	public void findPersonList() {
		 HouseBiz biz=CgLibTransProxyUtil.getTransProxyObject(HouseBiz.class);//利用代理模式
	/*	User u =new User();
		u.setUser_name("a");
		u.setUser_account("a");
		u.setUser_password("1");
		u.setUser_phone(123);
		u.setUser_state("asd");
		biz.addUser(u);*/
//		List<HouseIo> a = biz.SelAllHouse();
//		System.out.println(a);
	
		 
	}
}
