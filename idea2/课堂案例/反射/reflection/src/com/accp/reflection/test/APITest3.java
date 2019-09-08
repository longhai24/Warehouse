package com.accp.reflection.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class APITest3 {

	/**
	 * 
	* @title: main 
	* @description: 动态创建Person对象 调用指定构造方法 修改指定属性 调用指定方法
	* @param args
	 */
	public static void main(String[] args)throws Exception {
		/* 
		 * Person temp=new Person("史真香", 18);
		 * temp.setName("阿香");->temp.name="阿香"; temp.setAge(28);->temp.age=28;
		 * temp.show();
		 * double val=temp.plusNum(1,1.1); 
		 */
		Class cls=Class.forName("com.accp.reflection.entity.Person");
		//cls.newInstance();//默认无参构造方法
		//获得指定构造方法
		Constructor c=cls.getDeclaredConstructor(String.class,Integer.class);
		//初始化
		Object obj=c.newInstance("史真香",18);
		//获得指定属性
		Field fName=cls.getDeclaredField("name");
		fName.setAccessible(true);//非常重要
		//修改属性
		fName.set(obj,"阿香");//obj属性的归属者
		//获得属性
		//System.out.println(fName.get(obj));
		//获得指定方法
		//Method mShow=cls.getDeclaredMethod("show");
		//调用方法
		//Object returnVal=mShow.invoke(obj);
		Method mShow=cls.getDeclaredMethod("plusNum",int.class,double.class);
		Object returnVal=mShow.invoke(obj,1,1.1);
		System.out.println(returnVal);
	}

}
