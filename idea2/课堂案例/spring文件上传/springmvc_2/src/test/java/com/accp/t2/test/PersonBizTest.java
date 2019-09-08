package com.accp.t2.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accp.t2.biz.PersonBiz;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-ctx.xml" })
public class PersonBizTest {

	@Resource
	private PersonBiz biz;

	@Test
	public void testQueryPerson() {
		biz.findPersonListByPage(1, 2);
	}

	@Test
	public void testDelPerson() {
		biz.removePersonById(12);
	}

}
