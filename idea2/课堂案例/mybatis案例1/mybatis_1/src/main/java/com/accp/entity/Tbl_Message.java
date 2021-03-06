package com.accp.entity;

import java.util.Date;

public class Tbl_Message {
	private Integer id;
	private String userName;
	private String title;
	private String contents;
	private Date createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Tbl_Message(Integer id, String userName, String title, String contents, Date createTime) {
		super();
		this.id = id;
		this.userName = userName;
		this.title = title;
		this.contents = contents;
		this.createTime = createTime;
	}
	public Tbl_Message() {
		super();
	}
	public Tbl_Message(String userName, String title, String contents, Date createTime) {
		super();
		this.userName = userName;
		this.title = title;
		this.contents = contents;
		this.createTime = createTime;
	}
	
}
