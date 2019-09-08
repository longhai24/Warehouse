package com.accp.test;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.accp.entity.Tbl_Message;

public class Test {
	@org.junit.Test
	public void ma() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("主菜单\n------------------------------------\n1.查询留言\n2.添加留言\n3.退出");
			System.out.println("请输入: ");
			String co = sc.nextLine();
			switch (co) {
			case "1":
				QueryAll();
				break;
			case "2":
				into();
				break;
			case "3":
				System.exit(0);
				break;
			default:
				System.exit(0);
				break;
			}
		}
	}

	@org.junit.Test
	public void QueryAll() {
		// 1.构建，解析config配置文件
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSession dao = null;
		try {
			// 2.获得工厂
			SqlSessionFactory ssf = ssfb.build(Resources.getResourceAsStream("config.xml"));
			// 3.获得缓存对象
			dao = ssf.openSession();
			// 4.操作(CRUD) statement:namespace.id
			List<Tbl_Message> data = dao.selectList("com.accp.dao.lq.queryAll");
			for (Tbl_Message t : data) {
				System.out.println("留言人:" + t.getUserName() + "留言标题:" + t.getTitle() + "时间:" + t.getCreateTime() + "内容"
						+ t.getContents());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dao.close();
		}
	}

	/**
	 * 添加
	 */
	@org.junit.Test
	public void into() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入留言人姓名: ");
		String username = sc.nextLine();
		System.out.println("请输入留言标题: ");
		String tite = sc.nextLine();
		System.out.println("请输入留言内容: ");
		String n = sc.nextLine();
		Tbl_Message tb = new Tbl_Message(username, tite, n, new Date());
		// 1.构建，解析config配置文件
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSession dao = null;
		try {
			// 2.获得工厂
			SqlSessionFactory ssf = ssfb.build(Resources.getResourceAsStream("config.xml"));
			// 3.获得缓存对象
			dao = ssf.openSession();
			// 4.操作(CRUD) statement:namespace.id
			int i = dao.insert("com.accp.dao.lq.into", tb);
			if (i != 0) {
				System.out.println("留言成功");
				dao.commit();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			dao.rollback();

		} finally {
			dao.close();
		}
	}
}
