package com.accp.work.entity;

import java.util.ArrayList;

/**
 * 
* <p>Title: Tender</p>  
* <p>Description:�洢Tender����� </p>  
* @author Apple 

* @date 2019��4��3��
 */
public class Tender {

	public Tender() {
		super();
	}
	private String project_name;//��������
	private Integer tender_id;//���
	private ArrayList<Bid> blist;//����Bid�ļ���
	
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
