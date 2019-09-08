package com.accp.entity;

import java.util.Date;

public class Person {
	private Integer pid;
	private String pname;
	private Integer psex;
	private Date pdate;
	private String pimg;
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Integer getPsex() {
		return psex;
	}
	public void setPsex(Integer psex) {
		this.psex = psex;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public String getPimg() {
		return pimg;
	}
	public void setPimg(String pimg) {
		this.pimg = pimg;
	}
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", psex=" + psex + ", pdate=" + pdate + ", pimg=" + pimg
				+ "]";
	}
	public Person(String pname, Integer psex, Date pdate, String pimg) {
		super();
		this.pname = pname;
		this.psex = psex;
		this.pdate = pdate;
		this.pimg = pimg;
	}
	public Person() {
		super();
	}
	
	
	
	
}
