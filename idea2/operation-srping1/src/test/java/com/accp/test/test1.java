package com.accp.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acpp.pojo.staff;

public class test1 {
	@Test
	public void test() {
		ApplicationContext  ac=new ClassPathXmlApplicationContext("test1.xml");
		staff f = (staff)ac.getBean("liqi");
		System.out.println(f);
	}
}
