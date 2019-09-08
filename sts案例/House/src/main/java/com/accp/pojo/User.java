package com.accp.pojo;

/**
 * 
* <p>Title: User</p>  
* <p>Description:用户实体类 </p>  
* @author Apple 

* @date 2019年5月13日
 */
public class User {

	private Integer user_Id;// 用户id
	private String user_account;// 用户账号
	private String user_password;// 用户密码
	private String user_name;// 用户名称
	private Integer user_phone;// 用户电话
	private String user_state;// 用户状态
	@Override
	public String toString() {
		return "User [user_Id=" + user_Id + ", user_account=" + user_account + ", user_password=" + user_password
				+ ", user_name=" + user_name + ", user_phone=" + user_phone + ", user_state=" + user_state + "]";
	}
	public User() {
		super();
	}
	public Integer getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(Integer user_Id) {
		this.user_Id = user_Id;
	}
	public String getUser_account() {
		return user_account;
	}
	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Integer getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(Integer user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_state() {
		return user_state;
	}
	public void setUser_state(String user_state) {
		this.user_state = user_state;
	}
}
