package com.accp.pojo;

import java.util.List;

public class City {
	private Integer cid;
	private String cname;
	private Province p;
	private List<District> diss;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Province getP() {
		return p;
	}
	public void setP(Province p) {
		this.p = p;
	}
	public List<District> getDiss() {
		return diss;
	}
	public void setDiss(List<District> diss) {
		this.diss = diss;
	}
	@Override
	public String toString() {
		return "City [cid=" + cid + ", cname=" + cname + ", p=" + p + ", diss=" + diss + "]";
	}
	
}
