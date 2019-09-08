package com.accp.entity;

public class DepstaEntity {
	private Integer sid;
	private String sname;
	private String sgz;
	private float smoney;
	private String stime;
	private float sjang;
//	private Integer did;
	private DepEntity dep;
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
	public String getSgz() {
		return sgz;
	}
	public void setSgz(String sgz) {
		this.sgz = sgz;
	}
	public float getSmoney() {
		return smoney;
	}
	public void setSmoney(float smoney) {
		this.smoney = smoney;
	}
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public float getSjang() {
		return sjang;
	}
	public void setSjang(float sjang) {
		this.sjang = sjang;
	}
	public DepEntity getDep() {
		return dep;
	}
	public void setDep(DepEntity dep) {
		this.dep = dep;
	}
	public DepstaEntity(Integer sid, String sname, String sgz, float smoney, String stime, float sjang, DepEntity dep) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sgz = sgz;
		this.smoney = smoney;
		this.stime = stime;
		this.sjang = sjang;
		this.dep = dep;
	}
	public DepstaEntity() {
		super();
	}
	public DepstaEntity(String sname, String sgz, float smoney, String stime, float sjang, DepEntity dep) {
		super();
		this.sname = sname;
		this.sgz = sgz;
		this.smoney = smoney;
		this.stime = stime;
		this.sjang = sjang;
		this.dep = dep;
	}
	
}
