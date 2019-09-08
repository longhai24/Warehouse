package com.accp.test;

import java.io.IOException;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accp.dao.IbillDao;
import com.accp.pojo.Bill;
import com.accp.pojo.Detail;

public class test {
	private SqlSession session;
	Scanner sc = new Scanner(System.in);
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
	public void selectAll() {
		IbillDao dao = session.getMapper(IbillDao.class);
		System.out.println("请输入订单号: ");
		String co = sc.nextLine();
		Bill bill= dao.selectAll(co);
		System.out.println(bill);
		System.out.println("订单详情:");
		for (Detail d : bill.getDetail()) {
			System.out.println(d);
		}
	}
	@Test
	public void delete() {
		IbillDao dao = session.getMapper(IbillDao.class);
		System.out.println("请输入订单号: ");
		Integer co = sc.nextInt();
		int i = dao.delete(co);
		if(i>0) {
			session.commit();
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
	}
}
