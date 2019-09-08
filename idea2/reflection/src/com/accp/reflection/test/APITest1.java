package com.accp.reflection.test;

import com.accp.reflection.entity.Person;

public class APITest1 {

	/**
	 * 
	* @title: main 
	* @description: 获得Class（字节码信息）产生三种方式
	* @param args
	 */
	public static void main(String[] args) {
		//类加载 2.分配内存空间 3.初始化构造信息=实例化
		Person person=new Person();
		//1，通过已知对象获得
		Class cls1=person.getClass();
		//2，通过已知类型获得
		Class cls2=Person.class;
		//3.运行时获得类型【非常重要】
		try {
			Class cls3=Class.forName("com.accp.reflection.entity.Person");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(cls1);
	}

}
