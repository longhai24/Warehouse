package com.accp.entity;

import com.accp.dao.Table;


/**
 * 员工类
 * @author psm
 *
 */
@Table(value="Employee")
public class Employee {
	
	//员工号，姓名，性别，住址，金额，年份
	private Integer id;
	private String name;
	private String sex;
	private String address;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Employee() {
		super();
	}
	public Employee(Integer id, String name, String sex, String address) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.address = address;
	}
	public Employee(String name, String sex, String address) {
		super();
		this.name = name;
		this.sex = sex;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", sex=" + sex + ", address=" + address + "]";
	}

}
