package com.accp.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class test_01 {
	public static void main(String[] args) {
		try {
			Class cls = Class.forName("java.lang.String");
			System.out.println(cls.getName()); // 获取完全限定名
			System.out.println(cls.getSimpleName()); // 简明
			Package pg = cls.getPackage();
			System.out.println("包名:" + pg.getName());
			System.out.println("接口信息:");
			for(Class c:cls.getInterfaces()) {
				System.out.println(c);
			}
			System.out.println("构造方法信息:");
			for(Constructor c:cls.getDeclaredConstructors()) {
				System.out.println(c);
			}
			System.out.println("属性信息:");
			for(Field c:cls.getDeclaredFields()) {
				System.out.println(c.getName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
