package com.accp.test;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accp.dao.IStu;
import com.accp.pojo.clazz;
import com.accp.pojo.stu;

public class test {

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
	public void DelStu() {
		IStu dao = session.getMapper(IStu.class);
		Integer num = dao.DelStuByStuId(1);
		if (num !=0) {
			session.commit();
		}else {
			session.rollback();
		}
	}
	@Test
	public void UpdateStu() {
		IStu dao = session.getMapper(IStu.class);
		Integer num = dao.UpdateStuByStuid(2, 2);
		if (num!=0) {
			session.commit();
		}else {
			session.rollback();
		}
	}
	@Test
	public void SelClazz(){
		IStu dao = session.getMapper(IStu.class);
		clazz c = dao.SelAllStuByClazz(1);
		System.out.println(c);
		for (stu c1 : c.getStulist()) {
			System.out.println(c1);
		}
	}
	@Test
	public void asad(){
		IStu dao = session.getMapper(IStu.class);
		stu c = dao.SelSomeStuBystuid(2);
		System.out.println(c);
		System.out.println(c.getCla());
	}
}
