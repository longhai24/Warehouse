package test;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;



import entity.Stu;

public class TestAll {
	Scanner input = new Scanner(System.in); 
	@Test
	public void testAll() {
		System.out.println("ACCP学员管理系统");
		System.out.println("1.添加学员信息");
		System.out.println("2.修改学员信息");
		System.out.println("3.删除学员信息");
		System.out.println("4.查询所有学员信息");
		System.out.println("5.根据学员姓名模糊查询学员信息");
		int sum = input.nextInt();
		switch (sum) {
		case 1:
			System.out.println("请输入学生姓名：");
			String name = input.next();
			System.out.println("请输入性别：");
			String sex = input.next();
			System.out.println("请输入学号：");
			String number = input.next();
			System.out.println("请输入年龄：");
			Integer age = input.nextInt();
			Stu stu1 = new Stu();
			stu1.setStuage(age);
			stu1.setStuname(name);
			stu1.setStuno(number);
			stu1.setStusex(sex);
			add(stu1);
			break;
		case 2:
			System.out.println("请输入要修改的学号:");
			String uid = input.next();
			System.out.println("请输入修改后的姓名:");
			String uname = input.next();
			System.out.println("请输入修改后的性别:");
			String usex = input.next();
			System.out.println("请输入修改后的年龄:");
			Integer uage = input.nextInt();
			Stu stu2 = new Stu();
			stu2.setStuage(uage);
			stu2.setStuname(uname);
			stu2.setStuno(uid);
			stu2.setStusex(usex);
			update(stu2);
			break;
		case 3:
			System.out.println("请输入要删除的学号");
			String delid = input.next();
			del(delid);
			break;
		case 4:
			List<Map<String,Object>>li =  selAll();
			for (Map<String, Object> map : li) {
				System.out.println("姓名："+map.get("stuname"));
				System.out.println("学号："+map.get("stuno"));
				System.out.println("性别："+map.get("stusex"));
				System.out.println("年龄："+map.get("stuage"));
				System.out.println();
			}
		break;
		case 5:
			System.out.println("请输入要查询的学生姓名：");
			String sname = input.next();
			List<Map<String,Object>> li2 = selSome(sname);
			for (Map<String, Object> map : li2) {
				System.out.println("姓名："+map.get("stuname"));
				System.out.println("学号："+map.get("stuno"));
				System.out.println("性别："+map.get("stusex"));
				System.out.println("年龄："+map.get("stuage"));
				System.out.println();
			}
			break;
		default:
			break;
		}
	}
	
	//新增
	public Integer add(Stu stu) {
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSession dao=null;
		Integer num = 0;
		try {
			SqlSessionFactory ssf = ssfb.build(Resources.getResourceAsStream("config.xml"));
			dao = ssf.openSession();
			num = dao.insert("com.accp.sum3.add", stu);
			if (num !=0) {
				System.out.println("新增成功");
				dao.commit();
			}
		} catch (Exception e) {
			dao.rollback();
			e.printStackTrace();
		}
		return num;
	}
	
	//删除学生
	public void del(String num) {
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSession dao=null;
		int count = 0;
		try {
			SqlSessionFactory ssf = ssfb.build(Resources.getResourceAsStream("config.xml"));
			dao = ssf.openSession();
			count =dao.delete("com.accp.sum3.del",num);
			if(count!=0) {
				System.out.println("删除成功");
				dao.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			dao.rollback();
		}
	}
	//模糊查询
	public List<Map<String,Object>> selSome(String sname){
		List<Map<String,Object>> list  = null;
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSession dao=null;
		try {
			SqlSessionFactory ssf = ssfb.build(Resources.getResourceAsStream("config.xml"));
			dao = ssf.openSession();
			list = dao.selectList("com.accp.sum3.selSome",sname);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dao.close();
		}
		return list;
	}
	
	//修改
	public  void update(Stu stu) {
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSession dao=null;
		try {
			SqlSessionFactory ssf = ssfb.build(Resources.getResourceAsStream("config.xml"));
			dao = ssf.openSession();
			Integer count =dao.delete("com.accp.sum3.update",stu);
			if (count !=0) {
				System.out.println("修改成功");
				dao.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			dao.rollback();
		}
	}
	//查询所有
	public List<Map<String,Object>> selAll(){
		List<Map<String,Object>> list  = null;
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSession dao=null;
		try {
			SqlSessionFactory ssf = ssfb.build(Resources.getResourceAsStream("config.xml"));
			dao = ssf.openSession();
			list  =dao.selectList("com.accp.sum3.selAll");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dao.close();
		}
		return list;
	}
}
