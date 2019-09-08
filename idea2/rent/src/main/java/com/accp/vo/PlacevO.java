package com.accp.vo;

public class PlacevO {
	private Integer sid;
	private String sname;
	private String dname;
	private String did;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	@Override
	public String toString() {
		return "PlacevO [sid=" + sid + ", sname=" + sname + ", dname=" + dname + ", did=" + did + "]";
	}
	
	
}
