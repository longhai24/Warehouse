package com.accp.work.entity;

import java.util.ArrayList;

/**
 * 
* <p>Title: Bid</p>  
* <p>Description:�洢Bid����� </p>  
* @author Apple 

* @date 2019��4��3��
 */
public class Bid {
	
	private Integer bid_id;//���
	private String company;//��˾����
	
	
	public Bid(Integer bid_id, String company) {
		super();
		this.bid_id = bid_id;
		this.company = company;

	
	}

	public Integer getBid_id() {
		return bid_id;
	}
	public void setBid_id(Integer bid_id) {
		this.bid_id = bid_id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Bid [bid_id=" + bid_id + ", company=" + company + "]";
	}

	

	
}
