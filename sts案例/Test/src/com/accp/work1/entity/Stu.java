package com.accp.work1.entity;

import java.util.Date;
/**
 * 
* <p>Title: Stu</p>  
* <p>Description:ѧ������洢 </p>  
* @author Apple 

* @date 2019��4��2��
 */
public class Stu {
	private Integer stuId;//ѧ��ID
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
	private String stuName;//ѧ������
	private Integer stuAge;//ѧ������
	private Integer stuSex;//ѧ���Ա�
	private Date stuDate;//ѧ����ѧ����
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
