package com.accp.work.entity;

import java.util.ArrayList;

/**
 * 
* <p>Title: Tender</p>  
* <p>Description:存储Tender类对象 </p>  
* @author Apple 

* @date 2019年4月3日
 */
public class Tender {

	public Tender() {
		super();
	}
	private String project_name;//工程名称
	private Integer tender_id;//编号
	private ArrayList<Bid> blist;//包含Bid的集合
	
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public Integer getTender_id() {
		return tender_id;
	}
	public void setTender_id(Integer tender_id) {
		this.tender_id = tender_id;
	}
	public Tender(String project_name, Integer tender_id) {
		super();
		this.project_name = project_name;
		this.tender_id = tender_id;
	}
	
	public Tender(String project_name, Integer tender_id, ArrayList<Bid> blist) {
		super();
		this.project_name = project_name;
		this.tender_id = tender_id;
		this.blist = blist;
	}
	public ArrayList<Bid> getBlist() {
		return blist;
	}
	public void setBlist(ArrayList<Bid> blist) {
		this.blist = blist;
	}
	@Override
	public String toString() {
		return "Tender [project_name=" + project_name + ", tender_id=" + tender_id + ", blist=" + blist + "]";
	}
	
}
