package com.accp.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.accp.entity.Student;

public class test {
	private String space = "com.accp.dao.lq.";
	private SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
	private SqlSession dao = null;
	private SqlSessionFactory ssf = null;
	@Test
	public void select() {
		try {
			ssf = ssfb.build(Resources.getResourceAsStream("config.xml"));
			dao = ssf.openSession();
			List<Student> list  = dao.selectList(space+"selectAll");
			for (Student s : list) {
				System.out.println("姓名:"+s.getStuname()+"年齡:"+s.getStuage()+"性别:"+s.getStusex()+"学号:"+s.getStuno());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void into() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入姓名: ");
			String username = sc.nextLine();
			System.out.println("请输入年龄: ");
			String tite = sc.nextLine();
			System.out.println("请输入性别: ");
			String n = sc.nextLine();
			Student s = new Student(username, tite, n);
			ssf = ssfb.build(Resources.getResourceAsStream("config.xml"));
			dao = ssf.openSession();
			int i = dao.insert(space+"into",s);
			if(i!=0) {
				System.out.println("新增成功");
				dao.commit();
			}
		} catch (IOException e) {
			dao.rollback();
			e.printStackTrace();
		}
	}
	@Test
	public void update() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入学号: ");
		String stino = sc.nextLine();
		try {
			ssf = ssfb.build(Resources.getResourceAsStream("config.xml"));
			dao = ssf.openSession();
			Student s = dao.selectOne(space+"selectid",stino);
			if(!stino.equals(s.getStuno().toString())) {
				System.out.println("学号不存在");
				return;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("请输入姓名: ");
		String username = sc.nextLine();
		System.out.println("请输入年龄: ");
		String tite = sc.nextLine();
		System.out.println("请输入性别: ");
		String n = sc.nextLine();
		Student s = new Student(Integer.valueOf(stino),username, tite, n);
		try {
			ssf = ssfb.build(Resources.getResourceAsStream("config.xml"));
			dao = ssf.openSession();
			int i = dao.update(space+"update",s);
			if(i != 0) {
				System.out.println("修改成功");
				dao.commit();
			}
		} catch (IOException e) {
			dao.rollback();
			e.printStackTrace();
		}
	}
	@Test
	public void delete() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入学号: ");
		String stino = sc.nextLine();
		try {
			ssf = ssfb.build(Resources.getResourceAsStream("config.xml"));
			dao = ssf.openSession();
			Student s = dao.selectOne(space+"selectid",stino);
			if(!stino.equals(s.getStuno().toString())) {
				System.out.println("学号不存在");
				return;
			}else {
				int i = dao.delete(space+"delete",stino);
				if(i>0) {
					System.out.println("删除成功");
					dao.commit();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			dao.rollback();
			e.printStackTrace();
		}
	}
	@Test
	public void like() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入查询姓名: ");
		String name = sc.nextLine();
		try {
			ssf = ssfb.build(Resources.getResourceAsStream("config.xml"));
			dao = ssf.openSession();
			Map<String, String> param=new HashMap<String,String>();
			param.put("name", name);
			List<Student> list = dao.selectList(space+"like",param);
			for (Student s : list) {
				System.out.println("姓名:"+s.getStuname()+"年齡:"+s.getStuage()+"性别:"+s.getStusex()+"学号:"+s.getStuno());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
