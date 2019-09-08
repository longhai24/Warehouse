package com.accp.entity;

public class Student {
	private Integer stuno;
	private String stuname;
	private String stusex;
	private String stuage;
	public Integer getStuno() {
		return stuno;
	}
	public void setStuno(Integer stuno) {
		this.stuno = stuno;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public String getStusex() {
		return stusex;
	}
	public void setStusex(String stusex) {
		this.stusex = stusex;
	}
	public String getStuage() {
		return stuage;
	}
	public void setStuage(String stuage) {
		this.stuage = stuage;
	}
	public Student(Integer stuno, String stuname, String stusex, String stuage) {
		super();
		this.stuno = stuno;
		this.stuname = stuname;
		this.stusex = stusex;
		this.stuage = stuage;
	}
	public Student() {
		super();
	}
	public Student(String stuname, String stusex, String stuage) {
		super();
		this.stuname = stuname;
		this.stusex = stusex;
		this.stuage = stuage;
	}
	
}
