package com.accp.one.entity;

import java.util.Date;

public class StudentEntity {
	private Integer id;
	private String name;
	private String sex;
	private int age;
	private Date time;
	
	public StudentEntity(String name, String sex, int age, Date time) {
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.time = time;
	}

	public StudentEntity(Integer id, String name, String sex, int age, Date time) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.time = time;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", time=" + time + "]";
	}

	
	
}
