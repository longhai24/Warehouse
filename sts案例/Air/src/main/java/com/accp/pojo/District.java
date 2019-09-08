package com.accp.pojo;

/**
 * 
* <p>Title: District</p>  
* <p>Description: 区域实体类</p>  
* @author Apple 

* @date 2019年5月18日
 */
public class District {
	
	private Integer id;
	private String name;
	@Override
	public String toString() {
		return "District [id=" + id + ", name=" + name + "]";
	}
	public District() {
		super();
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
}
