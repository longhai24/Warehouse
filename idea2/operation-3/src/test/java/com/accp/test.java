package com.accp;

import java.util.Date;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accp.dao.IAirInfo;
import com.accp.pojo.AirInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class test {
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
	//查询所有
	@Test
	public void selectAll() {
		int j = 1;
		for (;true;) {
			IAirInfo dao = session.getMapper(IAirInfo.class);
			PageHelper.startPage(j, 2);
			AirInfo a = new AirInfo();
			PageInfo<AirInfo> pageInfo=new PageInfo<AirInfo>(dao.selectAll(a));
			System.out.println("航班信息:");
			for (AirInfo a1 : pageInfo.getList()) {
				System.out.println(a1);
			}
			System.out.println("是否下一页(y,n)");
			Scanner in = new Scanner(System.in);
			String ye = in.nextLine();
			if("y".equals(ye)) {
				if(!pageInfo.isHasNextPage()) {
					System.out.println("没有下一页");
					break;
				}else {
					j++;
				}
			}
		}
	}
	//根据指定条件删除
	@Test
	public void delete() {
		IAirInfo dao = session.getMapper(IAirInfo.class);
		AirInfo air = new AirInfo();
		air.setId("1");
		int i = dao.delete(air);
		if(i >  0) {
			System.out.println("删除成功");
			session.commit();
		}else {
			System.out.println("删除失败");
		}
	}
	//修改航班
	@Test
	public void update() {
		IAirInfo dao = session.getMapper(IAirInfo.class);
		AirInfo air = new AirInfo();
		air.setId("1");
		air.setDestination("123");
		int i = dao.update(air);
		if(i > 0 ) {
			session.commit();
			System.out.println("修改成功");
		}else  
			System.out.println("修改失败");
		
	}
	//新增
	@Test
	public void addition() {
		IAirInfo dao = session.getMapper(IAirInfo.class);
		AirInfo air = new AirInfo();
		air.setId("2");
		air.setFlight_number("ML-25");
		air.setDestination("汨罗");
		air.setFlight_date(new Date());
		int i = dao.addition(air);
		if(i > 0 ) {
			System.out.println("新增成功");
		}else
			System.out.println("新增失败");
	}
}
