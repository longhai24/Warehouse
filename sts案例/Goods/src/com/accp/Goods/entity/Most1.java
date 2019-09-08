package com.accp.Goods.entity;

public class Most1 {
	
	private Integer uid;
	private Integer urid;
	private String uname;
	private String sname;
	private Integer dtype;
	public Most1(Integer uid, Integer urid, String uname, String sname, Integer dtype) {
		super();
		this.uid = uid;
		this.urid = urid;
		this.uname = uname;
		this.sname = sname;
		this.dtype = dtype;
	}
	public Integer getDtype() {
		return dtype;
	}
	public void setDtype(Integer dtype) {
		this.dtype = dtype;
	}
	public Most1(Integer uid, Integer urid, String uname, String sname) {
		super();
		this.uid = uid;
		this.urid = urid;
		this.uname = uname;
		this.sname = sname;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getUrid() {
		return urid;
	}
	public void setUrid(Integer urid) {
		this.urid = urid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
}
