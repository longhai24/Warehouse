package com.accp.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class test_02 {
	public static void main(String[] args) throws Exception {
		Class cls = Class.forName("java.lang.String");// 类加载
		Constructor c = cls.getDeclaredConstructor(String.class);// 获得指定构造函数
		Object obj = c.newInstance("  qwertyuiopasdfghjklzxcvbnm  ");// 初始化
		Method mshow = cls.getDeclaredMethod("length");// 获得length方法
		Object returnval = mshow.invoke(obj);// 调用length方法
		System.out.println("length:" + returnval);
		Method mindexof = cls.getDeclaredMethod("indexOf", String.class);// 获得indexof方法
		Object returnindexof = mindexof.invoke(obj, "a");// 调用indexof方法
		System.out.println("调用indexof()判断a" + returnindexof);
		Method mtrim = cls.getDeclaredMethod("trim");//
		Object returntrim = mtrim.invoke(obj);
		System.out.println("trim去空格" + returntrim);

	}
}
