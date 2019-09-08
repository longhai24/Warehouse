package test;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.IGoods;
import pojo.tb_bill;
import pojo.tb_detail;

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
	public void testQueryAll() throws Exception {
		// 使用session
		IGoods dao = session.getMapper(IGoods.class);
		for (tb_bill person : dao.SelAllBillByBillno("no1")) {
			System.out.println(person);
			System.out.println("订单详情:");
			// 获得关联关系属性
			for (tb_detail address : person.getBill()) {
				System.out.println(address);
			}
		}
	}
	
	@Test
	public void del()throws Exception{
		IGoods dao = session.getMapper(IGoods.class);
		Integer i = dao.DelByBillno("no3");
		System.out.println(i);
		if (i!=0) {
			session.commit();
		}else {
			session.rollback();
		}
		}
	
}
