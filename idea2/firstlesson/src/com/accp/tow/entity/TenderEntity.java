package com.accp.tow.entity;

public class TenderEntity {
	private Integer tender_id;
	private String project_name;
	public Integer getTender_id() {
		return tender_id;
	}
	public void setTender_id(Integer tender_id) {
		this.tender_id = tender_id;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public TenderEntity(Integer tender_id, String project_name) {
		this.tender_id = tender_id;
		this.project_name = project_name;
	}
	public TenderEntity() {
	}
	public TenderEntity(String project_name) {
		this.project_name = project_name;
	}
	@Override
	public String toString() {
		return "TenderEntity [tender_id=" + tender_id + ", project_name=" + project_name + "]";
	}
	
	
}
