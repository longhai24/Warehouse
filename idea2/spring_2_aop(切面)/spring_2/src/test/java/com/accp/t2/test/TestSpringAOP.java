package com.accp.t2.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accp.t2.biz.PersonBiz;


public class TestSpringAOP {

	@Test
	public void testBizAOP() throws Exception {
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-ctx.xml");
		PersonBiz biz=(PersonBiz)ac.getBean("biz");
		//biz.addPerson();
		biz.findPerson();
	}

}
