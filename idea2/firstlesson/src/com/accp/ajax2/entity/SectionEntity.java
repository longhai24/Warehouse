package com.accp.ajax2.entity;

public class SectionEntity {
	private Integer id;
	private String name;
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
	public SectionEntity(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	public SectionEntity() {
	}
	
}
