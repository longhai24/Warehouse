package com.accp.t2.test;

import java.io.IOException;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accp.t2.biz.PersonBiz;
import com.accp.t2.dao.IPersonDao;
import com.accp.t2.pojo.Address;
import com.accp.t2.pojo.Person;

public class PersonDaoTest {

	private SqlSession session;

	@Before
	public void init() {
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf = null;
		try {
			ssf = ssfb.build(Resources.getResourceAsStream("config.xml"));
			session = ssf.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@After
	public void release() {
		session.close();
	}

	@Test
	public void testQueryAll() throws Exception {
		// 使用session
		IPersonDao dao = session.getMapper(IPersonDao.class);
		for (Person person : dao.queryPersonsByLike("李")) {
			System.out.println(person);
			System.out.println("收货地址:");
			// 获得关联关系属性
			for (Address address : person.getAddresses()) {
				System.out.println(address);
			}
		}
	}

	@Test
	public void testQueryAllPersonWithAddress() throws Exception {
		// 使用session
		IPersonDao dao = session.getMapper(IPersonDao.class);
		for (Person person : dao.queryAllPersonWithAddress()) {
			System.out.println(person);
			System.out.println("收货地址:");
			// 获得关联关系属性
			for (Address address : person.getAddresses()) {
				System.out.println(address);
			}
		}
	}

	@Test
	public void testQueryAllAddressWithPerson() throws Exception {
		// 使用session
		IPersonDao dao = session.getMapper(IPersonDao.class);
		for (Address address : dao.queryAllAdressWithPerson()) {
			System.out.println(address);
			System.out.println("会员信息:" + address.getPerson().getPersonName());

		}
	}

	@Test
	public void testAddPerson() throws Exception {

	}

	@Test
	public void testRemovePerson() throws Exception {
		IPersonDao dao = session.getMapper(IPersonDao.class);
		dao.deletePersonById(13);
		session.commit();
		
	}

}
