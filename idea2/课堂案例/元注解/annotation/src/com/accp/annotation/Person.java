package com.accp.annotation;

/**
 * 描述员工信息： 
 * 姓名 :史真香 
 * 英文名:ShiZhenXiang 
 * 性别:女 
 * 年龄:18
 */
//2.使用
@PersonInfo(age=18,enName="ShiZhenXiang")
public class Person {

	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person(String name) {
		super();
		
		this.name = name;
	}

	public Person() {
		super();
	}
	
	

}
