package com.accp.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acpp.biz.TestBizImpl;
import com.acpp.dao.BizDao;
import com.acpp.pojo.staff;

public class test2 {
	@Test
	public void test() {
		ApplicationContext  ac=new ClassPathXmlApplicationContext("test1.xml");
		BizDao biz = (BizDao)ac.getBean("test2");
		biz.add();
//		TestBizImpl biz = new TestBizImpl();
//		biz.add();
	}
}
