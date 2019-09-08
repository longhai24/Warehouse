package com.accp.tow.entity;

public class BidEntity {
	private Integer bid_id;
	private String company;
	@Override
	public String toString() {
		return "BidEntity [bid_id=" + bid_id + ", company=" + company + ", ten=" + ten + "]";
	}
	private TenderEntity ten;
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
	public TenderEntity getTen() {
		return ten;
	}
	public void setTen(TenderEntity ten) {
		this.ten = ten;
	}
	public BidEntity(Integer bid_id, String company, TenderEntity ten) {
		this.bid_id = bid_id;
		this.company = company;
		this.ten = ten;
	}
	public BidEntity() {
	}
	public BidEntity(String company, TenderEntity ten) {
		this.company = company;
		this.ten = ten;
	}
	
}
