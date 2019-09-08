package com.accp.singleton;

public class Person {
	// 2.提供私有静态常量引用对象
	// private static final Person person=new Person(); //饿汉单例 线程安全
	private static Person person;// 懒汉单例 线程不安全
	// 1.私有化构造方法

	private Person() {

	}

	// 3.提供公开的静态获得对象方法
	public static Person getInstance() {
		synchronized (Person.class) {
			if (person == null) {
				person = new Person();
			}
		}
		return person;
	}

	public void showInfo() {
		System.out.println(this + "对象单例模式调用Person的方法!");
	}

}
