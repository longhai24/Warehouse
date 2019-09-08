package com.accp.ajax.entity;

public class StaffEntity {
	private int id;
	private String name;
	private String site;
	private String emial;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getEmial() {
		return emial;
	}
	public void setEmial(String emial) {
		this.emial = emial;
	}
	public StaffEntity(int id, String name, String site, String emial) {
		this.id = id;
		this.name = name;
		this.site = site;
		this.emial = emial;
	}
	public StaffEntity() {
	}
	public StaffEntity(String name, String site, String emial) {
		this.name = name;
		this.site = site;
		this.emial = emial;
	}
	
}
