package com.accp.test;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accp.dao.IstudentDao;
import com.accp.pojo.Student;

public class StudentTest {
	private SqlSession session;
	Scanner sc = new Scanner(System.in);
	@Before
	public void init() {
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf = null;
		try {
			ssf = ssfb.build(Resources.getResourceAsStream("studnetConfig.xml"));
			session = ssf.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@After
	public void release() {
		session.close();
	}
	//删除学生
	@Test
	public void delete() {
		IstudentDao dao = session.getMapper(IstudentDao.class);
		System.out.println("请输入学生号: ");
		String co = sc.nextLine();
		int i = dao.delete(co);
		if(i>0) {
			System.out.println("删除成功");
			session.commit();
		}else {
			System.out.println("删除失败");
		}
	}
	//修改学生班级
	@Test
	public void update() {
		IstudentDao dao = session.getMapper(IstudentDao.class);
		System.out.println("请输入学生号: ");
		String co = sc.nextLine();
		System.out.println("输入转入的班级");
		String clazz = sc.nextLine();
		int i = dao.update(clazz, co);
		if(i>0) {
			session.commit();
			System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
	}
	//查询指定班级的所有学生姓名
	@Test
	public void selectClazzAll() {
		IstudentDao dao = session.getMapper(IstudentDao.class);
		System.out.println("输入查询的班级");
		String clazz = sc.nextLine();
		List<Student> stus = dao.selectClazzAll(clazz);
		for (Student student : stus) {
			System.out.println(student);
		}
	}
	//打印学生信息及班级信息
	@Test
	public void selectStudent() {
		IstudentDao dao = session.getMapper(IstudentDao.class);
		System.out.println("输入查询的学生号");
		String clazz = sc.nextLine();
		Student stu = dao.selectStudent(clazz);
		System.out.println( "学生信息"+stu);
		System.out.println("班级信息"+stu.getA());
	}
}
