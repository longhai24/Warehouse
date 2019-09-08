package com.accp.pojo;

public class Power {
	private Integer pid;
	private String pname;
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
	public Power() {
		super();
	}

	@Override
	public String toString() {
		return "Power{" +
				"pid=" + pid +
				", pname='" + pname + '\'' +
				'}';
	}
}
