package com.accp.pojo;

public class HouseType {
	private Integer tid;
	private String tname;
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	
	public HouseType() {
		super();
	}
	@Override
	public String toString() {
		return "HouseType [tid=" + tid + ", tname=" + tname + "]";
	}
	
}
