package com.accp.reflection.entity;

import java.io.Serializable;
import java.util.Comparator;


public final class Person  implements Serializable,Comparator {

	/** 
	* @fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 1L;

	private String name;

	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Person() {
		super();
	}
	
	private Person(String name) {
	}

	@Override
	public String toString() {

		return this.getName() + "\t" + this.getAge();
	}

	/**
	 * 显示详细信息
	 */
	public void show() {
		System.out.println("本人基本信息如下:");
		System.out.println("姓名:" + this.name);
		System.out.println("年龄:" + this.age);
	}

	/**
	 * 实例方法: 有参数方法动态调用
	 */
	public double plusNum(int num1, double num2) {
		return num1 + num2;
	}

	public static void showStatic() {
		System.out.println("调用静态方法");
	}

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
