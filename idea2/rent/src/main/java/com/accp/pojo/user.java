package com.accp.pojo;

public class user {
	private Integer uid;
	private String uname;
	private String upwd;
	private String uphone;
	private String ucompellation;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public String getUcompellation() {
		return ucompellation;
	}
	public void setUcompellation(String ucompellation) {
		this.ucompellation = ucompellation;
	}
	public user(Integer uid, String uname, String upwd, String uphone, String ucompellation) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.uphone = uphone;
		this.ucompellation = ucompellation;
	}
	public user(String uname, String upwd, String uphone, String ucompellation) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.uphone = uphone;
		this.ucompellation = ucompellation;
	}
	public user() {
		super();
	}
	
	@Override
	public String toString() {
		return "user [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd + ", uphone=" + uphone + ", ucompellation="
				+ ucompellation + "]";
	}
	
}
