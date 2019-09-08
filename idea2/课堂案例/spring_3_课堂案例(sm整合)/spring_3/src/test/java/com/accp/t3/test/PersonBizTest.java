package com.accp.t3.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accp.t3.biz.PersonBiz;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring-ctx.xml"})
public class PersonBizTest {
	
	@Autowired
	private PersonBiz personBiz;
	

	@Test
	public void testQueryPerson() {
		personBiz.findPersonListByPage(1, 3);
	}

	@Test
	public void testRemovePerson() {
		personBiz.removePersonById(10003);
		
	}

}
