package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.Tests;
import pojo.Human;

public class HumanTest {

	@Test
	public void show() {
		ApplicationContext  ac=new ClassPathXmlApplicationContext("test.xml");
		Tests biz=(Tests) ac.getBean("oo");
		biz.add();;
	}
}
