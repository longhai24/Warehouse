package com.accp.entity;

public class DepEntity {
	private Integer id;
	private String name;
	private String add;
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
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public DepEntity(Integer id, String name, String add) {
		super();
		this.id = id;
		this.name = name;
		this.add = add;
	}
	public DepEntity() {
		super();
	}
	public DepEntity(String name, String add) {
		super();
		this.name = name;
		this.add = add;
	}
	
}
