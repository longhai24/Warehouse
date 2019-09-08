package com.accp.ajax.entity;

/**
 * 
* <p>Title: Department</p>  
* <p>Description:部门实体对象类 </p>  
* @author Apple 

* @date 2019年4月9日
 */
public class Department {
	
	private Integer id ;//部门编号
	private String name;//部门名称
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
	public Department(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	
}
