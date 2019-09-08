package com.accp.pojo;

public class Street {
	private Integer sid;
	private String sname;
	private District d;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public District getD() {
		return d;
	}
	public void setD(District d) {
		this.d = d;
	}
	
	public Street() {
		super();
	}
	@Override
	public String toString() {
		return "Street [sid=" + sid + ", sname=" + sname + ", d=" + d + "]";
	}
	
}
