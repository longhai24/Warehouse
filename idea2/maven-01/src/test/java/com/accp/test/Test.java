package com.accp.test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {
	@org.junit.Test
	public void testSelect() {
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSession dao= null;
		try {
			SqlSessionFactory ssf = ssfb.build(Resources.getResourceAsStream("config.xml"));
			dao = ssf.openSession();
			List<Map<String, Object>> list = dao.selectList("com.accp.dao.IPlq.select");
			for (Map<String, Object> map : list) {
				System.out.println(map);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@org.junit.Test
	public void kk() {
		System.out.println("njk");
	}
}
