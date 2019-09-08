package com.accp.reflect.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
	@SuppressWarnings("all")
	public static void main(String[] args) {
		try {
			//Class cla = Class.forName("com.accp.reflect.entity.Reflect");
			Class cla2 = String.class;
//			System.out.println("������"+cla2.getSimpleName());
			Package pag = cla2.getPackage();
			System.out.println("����:"+pag.getName());
			System.out.println("����"+cla2.getSuperclass());
			for(Class c:cla2.getInterfaces()) {
				System.out.println("�ӿڣ�"+c);
			}
			for (Field c  : cla2.getDeclaredFields()) {
				System.out.println("��Ա������"+c);
			}
			for (Method c : cla2.getDeclaredMethods()) {
				System.out.println("��Ա������"+c);
			}
			
			for (Constructor c : cla2.getDeclaredConstructors()) {
				System.out.println("���췽����"+c);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			}

}
