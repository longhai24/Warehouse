package com.accp.pojo;

public class Student {
	private Integer sid;
	private String name;
	private String age;
	private String sex;
	private Add a;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Add getA() {
		return a;
	}
	public void setA(Add a) {
		this.a = a;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", age=" + age + ", sex=" + sex + ", a=" + a + "]";
	}
	
	
	
}
