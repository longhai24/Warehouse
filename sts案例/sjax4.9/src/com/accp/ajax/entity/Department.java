package com.accp.ajax.entity;

/**
 * 
* <p>Title: Department</p>  
* <p>Description:����ʵ������� </p>  
* @author Apple 

* @date 2019��4��9��
 */
public class Department {
	
	private Integer id ;//���ű��
	private String name;//��������
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
