package com.accp.reflection.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Vector;

public class APITest2 {

	/**
	 * 
	 * @title: main
	 * @description: 通过自审模式显示类成员相关API 
	 * 类名，
	 * 包名， 
	 * 访问修饰符， 
	 * 父类信息, 
	 * 接口
	 * 构造方法 
	 * 属性 
	 * 方法
	 *               1：getMethods(),该方法是获取本类以及父类或者父接口中所有的公共方法(public修饰符修饰的)
	 *               2:getDeclaredMethods(),该方法是获取本类中的所有方法，包括私有的(private、protected、默认以及public)的方法。
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Class cls=Class.forName("com.accp.reflection.entity.Person");
			System.out.println("类名:"+cls.getName());
			System.out.println("简名:"+cls.getSimpleName());
			Package pg=cls.getPackage();
			System.out.println("包名:"+pg.getName());
			System.out.println("访问修饰符:"+Modifier.toString(cls.getModifiers()));
			System.out.println("父类信息:"+cls.getSuperclass().getName());
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
				System.out.println(c);
			}
			System.out.println("方法信息:");
			for(Method c:cls.getDeclaredMethods()) {
				System.out.println(c);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
