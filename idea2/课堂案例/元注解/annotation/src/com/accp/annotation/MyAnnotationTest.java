package com.accp.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class MyAnnotationTest {

	public static void main(String[] args) throws Exception {
		Person person=new Person("史真香");
		System.out.println("姓名:"+person.getName());
		//3.运行时解析【非常重要】
		Class cls=person.getClass();
		//获得元注解
//		for(Annotation a:cls.getAnnotations()) {
//			PersonInfo p=(PersonInfo)a;
//			System.out.println("英文名:"+p.enName());
//			System.out.println("性别:"+p.sex());
//			System.out.println("年龄:"+p.age());
//		}
		//获得指定元注解
		if(cls.isAnnotationPresent(PersonInfo.class)) {
			PersonInfo p=(PersonInfo) cls.getDeclaredAnnotation(PersonInfo.class);
			System.out.println("英文名:"+p.enName());
			System.out.println("性别:"+p.sex());
			System.out.println("年龄:"+p.age());
		}
	}
}
