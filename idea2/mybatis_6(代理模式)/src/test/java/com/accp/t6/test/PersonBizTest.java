package com.accp.t6.test;

import java.util.Date;

import org.junit.Test;

import com.accp.t6.biz.PersonBiz;
import com.accp.t6.pojo.Person;
import com.accp.t6.util.CgLibTransProxyUtil;

public class PersonBizTest {

	@Test
	public void testProxyObject() throws Exception {
		PersonBiz biz=CgLibTransProxyUtil.getTransProxyObject(PersonBiz.class);
		biz.addPerson(new Person("小江江", 0, new Date(), "meng.jpg"));
	}
}
