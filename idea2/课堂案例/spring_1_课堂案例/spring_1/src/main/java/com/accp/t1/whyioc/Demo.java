package com.accp.t1.whyioc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accp.t1.biz.PersonBiz;
import com.accp.t1.pojo.Address;
import com.accp.t1.pojo.Person;

public class Demo {
	public static void main(String[] args) throws Exception {
		// 传统编程方式（硬编码）
//		// 1. 实例化,初始化组件
//		Person bean = new Person();
//		bean.setPname("罗玉凤");
//		bean.setPsex(1);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		bean.setPdate(sdf.parse("1990-11-11"));
//		List<String> loves = new ArrayList<String>();
//		loves.add("逛街");
//		loves.add("睡觉");
//		loves.add("卖萌");
//		bean.setLoves(loves);// 关系
//		List<Address> addresses = new ArrayList<Address>();
//		addresses.add(new Address("湖南株洲", "1383838438"));
//		addresses.add(new Address("湖南湘潭", "137......."));
//		bean.setAddresses(addresses);// 关系
//		// 2.使用组件
//		Printer lenovo = new Printer();
//		lenovo.setPerson(bean);// 关系
		//解析spring配置文件，构建spring环境
//		ApplicationContext  ac=new ClassPathXmlApplicationContext("spring-ctx.xml");
//		Printer lenovo1=(Printer) ac.getBean("printer");
//		System.out.println(lenovo1);
//		Printer lenovo2=(Printer) ac.getBean("printer");
//		System.out.println(lenovo2);
//		Printer lenovo3=(Printer) ac.getBean("printer");
//		System.out.println(lenovo3);
//		lenovo1.print();
		
		ApplicationContext  ac=new ClassPathXmlApplicationContext("sky.xml");
		PersonBiz biz=(PersonBiz) ac.getBean("biz");
		biz.addPerson();
	}
}
