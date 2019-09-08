package com.accp.pojo;

public class District {
	private Integer did;
	private String dname;
	private City c;
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public City getC() {
		return c;
	}
	public void setC(City c) {
		this.c = c;
	}
	@Override
	public String toString() {
		return "District [did=" + did + ", dname=" + dname + ", c=" + c + "]";
	}
	
}
