package com.accp.test;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.accp.entity.Person;

public class MyBatisTest {

	@Test
	public void testQueryAll() {
		// 1.构建，解析config配置文件
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSession dao=null;
		try {
			// 2.获得工厂
			SqlSessionFactory ssf = ssfb.build(Resources.getResourceAsStream("config.xml"));
			// 3.获得缓存对象
			dao = ssf.openSession();
			// 4.操作(CRUD) statement:namespace.id
			List<Map<String, Object>> data = dao.selectList("com.accp.dao.IPersonDao.queryAll");
			for (Map<String, Object> temp : data) {
				System.out.println(temp.get("pid") + "\t" + temp.get("pname") + "\t" + temp.get("psex") + "\t"
						+ temp.get("pdate") + "\t" + temp.get("pimg"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dao.close();
		}
	}
	
	@Test
	public void testLoad() {
		// 1.构建，解析config配置文件
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSession dao=null;
		try {
			// 2.获得工厂
			SqlSessionFactory ssf = ssfb.build(Resources.getResourceAsStream("config.xml"));
			// 3.获得缓存对象
			dao = ssf.openSession();
			// 4.操作(CRUD) statement:namespace.id
			Person temp=dao.selectOne("com.accp.dao.IPersonDao.load",4);
			System.out.println(temp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dao.close();
		}
	}
	
	
	@Test
	public void testQueryCount() {
		// 1.构建，解析config配置文件
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSession dao=null;
		try {
			// 2.获得工厂
			SqlSessionFactory ssf = ssfb.build(Resources.getResourceAsStream("config.xml"));
			// 3.获得缓存对象
			dao = ssf.openSession();
			// 4.操作(CRUD) statement:namespace.id
			Long temp=dao.selectOne("com.accp.dao.IPersonDao.queryCount");
			System.out.println(temp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dao.close();
		}
	}
	
	@Test
	public void testQueryLike() {
		// 1.构建，解析config配置文件
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSession dao=null;
		try {
			// 2.获得工厂
			SqlSessionFactory ssf = ssfb.build(Resources.getResourceAsStream("config.xml"));
			// 3.获得缓存对象
			dao = ssf.openSession();
			// 4.操作(CRUD) statement:namespace.id
			Map<String, Object> param=new HashMap<String,Object>();
			param.put("name", "李");
			param.put("sex", 1);
			List<Person> data=dao.selectList("com.accp.dao.IPersonDao.queryLike",param);
			for (Person person : data) {
				System.out.println(person);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dao.close();
		}
	}
	
	
	@Test
	public void testSave() {
		// 1.构建，解析config配置文件
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSession dao=null;
		try {
			// 2.获得工厂
			SqlSessionFactory ssf = ssfb.build(Resources.getResourceAsStream("config.xml"));
			// 3.获得缓存对象
			dao = ssf.openSession();
			// 4.操作(CRUD) statement:namespace.id
			int count=dao.insert("com.accp.dao.IPersonDao.save",new Person("小富富",0,new Date(),"meng.jpg"));
			if(count!=0) {
				System.out.println("新增成功");
				dao.commit();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			dao.rollback();
		}finally {
			dao.close();
		}
	}
	@Test
	public void testDelete() {
		// 1.构建，解析config配置文件
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSession dao=null;
		try {
			// 2.获得工厂
			SqlSessionFactory ssf = ssfb.build(Resources.getResourceAsStream("config.xml"));
			// 3.获得缓存对象
			dao = ssf.openSession();
			// 4.操作(CRUD) statement:namespace.id
			int count=dao.delete("com.accp.dao.IPersonDao.delete",16);
			if(count!=0) {
				System.out.println("删除成功");
				dao.commit();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			dao.rollback();
		}finally {
			dao.close();
		}
	}
}
