package com.accp.test;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.accp.entity.Message;

public class test {

	Scanner input = new Scanner(System.in);
	@Test
	public void testAll() {
		System.out.println("欢迎登陆留言板系统");
		System.out.println("主菜单");
		System.out.println("1.查询留言");
		System.out.println("2.添加留言");
		System.out.println("3.退出");
		System.out.println("请选择");
		Integer check = input.nextInt();
		if (check == 1) {
			List<Map<String,Object>> li = selAll();
			for (Map<String, Object> map : li) {
				System.out.println("留言人："+map.get("userName")+"\t留言时间："+map.get("createTime"));
				System.out.println("留言标题："+map.get("title"));
				System.out.println("留言内容："+map.get("contents"));
				System.out.println();
			}
		}else if (check ==2) {
			System.out.println("请输入留言人姓名：");
			String name = input.next();
			System.out.println("请输入留言标题：");
			String title = input.next();
			System.out.println("请输入留言内容：");
			String word = input.next();
			Message me = new Message();
			me.setCreateTime(new Date());
			me.setTitle(title);
			me.setUserName(name);
			me.setContents(word);
			add(me);
		}
		
		
	}
	
	public Integer add(Message me) {
		Integer num = 0;
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSession dao =null;
		try {
			SqlSessionFactory ssf = ssfb.build(Resources.getResourceAsStream("config.xml"));
			dao = ssf.openSession();
			num = dao.insert("com.accp.sum1.add", me);
			if (num !=0) {
				System.out.println("新增成功");
				dao.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			dao.rollback();
		}finally {
			dao.close();
		}
		return num;
	}
	
	public List<Map<String,Object>> selAll(){
		List<Map<String,Object>> data = null;
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSession dao =null;
		try {
			SqlSessionFactory ssf = ssfb.build(Resources.getResourceAsStream("config.xml"));
			dao = ssf.openSession();
			data = dao.selectList("com.accp.sum1.selAll");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dao.close();
		}
		return data;
	}
}
