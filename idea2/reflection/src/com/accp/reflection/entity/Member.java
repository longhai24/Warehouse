package com.accp.reflection.entity;

public class Member {
	
	private Integer id;
	private String username;
	private String upwd;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public Member(Integer id, String username, String upwd) {
		super();
		this.id = id;
		this.username = username;
		this.upwd = upwd;
	}

	public Member() {
		super();
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", username=" + username + ", upwd=" + upwd + "]";
	}
	
	

}
