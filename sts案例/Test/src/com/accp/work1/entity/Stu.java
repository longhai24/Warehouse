package com.accp.work1.entity;

import java.util.Date;
/**
 * 
* <p>Title: Stu</p>  
* <p>Description:学生对象存储 </p>  
* @author Apple 

* @date 2019年4月2日
 */
public class Stu {
	private Integer stuId;//学生ID
	public Integer getStuId() {
		return stuId;
	}
	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}
	public Stu(Integer stuId, String stuName, Integer stuAge, Integer stuSex, Date stuDate) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuAge = stuAge;
		this.stuSex = stuSex;
		this.stuDate = stuDate;
	}
	private String stuName;//学生名称
	private Integer stuAge;//学生年龄
	private Integer stuSex;//学生性别
	private Date stuDate;//学生入学日期
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public Integer getStuAge() {
		return stuAge;
	}
	public void setStuAge(Integer stuAge) {
		this.stuAge = stuAge;
	}
	public Integer getStuSex() {
		return stuSex;
	}
	public void setStuSex(Integer stuSex) {
		this.stuSex = stuSex;
	}
	public Date getStuDate() {
		return stuDate;
	}
	public void setStuDate(Date stuDate) {
		this.stuDate = stuDate;
	}
	public Stu(String stuName, Integer stuAge, Integer stuSex, Date stuDate) {
		super();
		this.stuName = stuName;
		this.stuAge = stuAge;
		this.stuSex = stuSex;
		this.stuDate = stuDate;
	}
	@Override
	public String toString() {
		return "Stu [stuId=" + stuId + ", stuName=" + stuName + ", stuAge=" + stuAge + ", stuSex=" + stuSex
				+ ", stuDate=" + stuDate + "]";
	}
	
}
