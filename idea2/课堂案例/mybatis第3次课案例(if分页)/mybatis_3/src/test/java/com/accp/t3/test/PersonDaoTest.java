package com.accp.t3.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accp.t3.dao.IPersonDao;
import com.accp.t3.pojo.Address;
import com.accp.t3.pojo.Person;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class PersonDaoTest {

	private SqlSession session;

	@Before
	public void init() throws Exception {
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf = ssfb.build(Resources.getResourceAsStream("config.xml"));
		session = ssf.openSession();
	}

	@After
	public void destory() {
		session.close();
	}

	@Test
	public void testQueryPerson() throws Exception {
		IPersonDao dao=session.getMapper(IPersonDao.class);
		for (Person p : dao.queryAllPersons()) {
			System.out.println("hy");
			System.out.println(p);
			for (Address a : p.getAdd()) {
				System.out.println("dz");
				System.out.println(a.getAname());
			}
		}
	}

	@Test
	public void testQueryPersonByPage() throws Exception {
		IPersonDao dao=session.getMapper(IPersonDao.class);
		//3.设置分页信息
		Integer pageNum=2;
		Integer pageSize=3;
		PageHelper.startPage(pageNum, pageSize);
		//构建分页对象【非常重要】
		PageInfo<Person> pageInfo=new PageInfo<Person>(dao.queryAllPersons());
		System.out.println("当前页:"+pageInfo.getPageNum());
		System.out.println("每页多少行:"+pageInfo.getPageSize());
		System.out.println("总行数:"+pageInfo.getTotal());
		System.out.println("总页数:"+pageInfo.getPages());
		System.out.println("上一页:"+pageInfo.getPrePage());
		System.out.println("下一页:"+pageInfo.getNextPage());
		System.out.println("是否有上一页:"+pageInfo.isHasPreviousPage());
		System.out.println("是否有下一页:"+pageInfo.isHasNextPage());
		System.out.println("当前页的数据");
		for (Person p : pageInfo.getList()) {
			System.out.println(p);
		}
	}

	@Test
	public void testQueryAllPersonsByParam1() throws Exception {
		IPersonDao dao=session.getMapper(IPersonDao.class);
		for(Person person:dao.queryAllPersonsByParam1("李", 1)) {
			System.out.println(person);
		}
	}

	@Test
	public void testQueryAllPersonsByParam2() throws Exception {
		IPersonDao dao=session.getMapper(IPersonDao.class);
		List<String> param=new ArrayList<String>();
		param.add("史真香");
		param.add("高富帅");
		param.add("李星星");
		for(Person person:dao.queryAllPersonsByParam2(param)) {
			System.out.println(person);
		}
	}

	@Test
	public void testSavePerson() throws Exception {
		IPersonDao dao=session.getMapper(IPersonDao.class);
		Person person=new Person(10001,"阿洋", 0,new Date(), "meng.jpg");
		person.getAdd().add(new Address("香港九龙", "1383838438"));
		person.getAdd().add(new Address("香港旺角", "13838385438"));
		dao.savePerson(person);
		session.commit();
	}

	@Test
	public void testUpdatePerson() throws Exception {
		IPersonDao dao=session.getMapper(IPersonDao.class);
		Person person=new Person(10001,"阿旺旺",1,new Date(),null);
		dao.updatePerson(person);
		session.commit();
	}

}
