package com.accp.ajax2.entity;

public class StaffEntity {
	private Integer id;
	private String name;
	private String address;
	private String email;
	private Integer course_3_sectionid;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getCourse_3_sectionid() {
		return course_3_sectionid;
	}
	public void setCourse_3_sectionid(Integer course_3_sectionid) {
		this.course_3_sectionid = course_3_sectionid;
	}
	public StaffEntity(Integer id, String name, String address, String email, Integer course_3_sectionid) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.course_3_sectionid = course_3_sectionid;
	}
	public StaffEntity() {
	}
	public StaffEntity(String name, String address, String email, Integer course_3_sectionid) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.course_3_sectionid = course_3_sectionid;
	}
	public StaffEntity(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}	
