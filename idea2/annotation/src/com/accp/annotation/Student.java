package com.accp.annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;



public class Student {
	
	public Student(int age, String name) {
		System.out.println("省略一万行初始化代码...");
	
	}

	public void show(String name, int age) {
		System.out.println("省略一万行业务代码...");
	}

	public static void main(String[] args) throws Exception {
		
		Class cl=Class.forName("com.accp.annotation.Student");
		Constructor con=cl.getDeclaredConstructor(int.class,String.class);
		Object tep=con.newInstance(6,"hhhh");
		Method me=cl.getMethod("show", String.class,int.class);
		me.invoke(tep, "cha",1);
	}
}
