package com.accp.t3.vo;

import java.util.Date;
import java.util.List;


import com.alibaba.fastjson.annotation.JSONField;

public class UserVo {

	private Integer userId;
	private String userName;
	private Byte userSex;
	@JSONField(format="yyyy-MM-dd")
	private Date userDate;
	private List<String> userLoves;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Byte getUserSex() {
		return userSex;
	}

	public void setUserSex(Byte userSex) {
		this.userSex = userSex;
	}

	public Date getUserDate() {
		return userDate;
	}

	public void setUserDate(Date userDate) {
		this.userDate = userDate;
	}

	public List<String> getUserLoves() {
		return userLoves;
	}

	public void setUserLoves(List<String> userLoves) {
		this.userLoves = userLoves;
	}

	public UserVo() {
		super();
	}

	public UserVo(Integer userId, String userName, Byte userSex, Date userDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userSex = userSex;
		this.userDate = userDate;
	}

	public UserVo(Integer userId, String userName, Byte userSex, Date userDate, List<String> userLoves) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userSex = userSex;
		this.userDate = userDate;
		this.userLoves = userLoves;
	}

}
