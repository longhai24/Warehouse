package com.accp.Goods.entity;

/**
 * 
 * <p>
 * Title: Users
 * </p>
 * <p>
 * Description: 用户实体类
 * </p>
 * 
 * @author Apple
 * 
 * @date 2019年4月9日
 */
public class Users {
	private Integer userid;// 用户编号
	private String username;// 用户姓名
	private String userpwd;// 用户密码
	private Integer rid;// 角色id
	private Integer dtype;//注销状态
	private String dtime;//注销时间

	public Integer getDtype() {
		return dtype;
	}

	public void setDtype(Integer dtype) {
		this.dtype = dtype;
	}

	public String getDtime() {
		return dtime;
	}

	public void setDtime(String dtime) {
		this.dtime = dtime;
	}

	public Users(Integer userid, String username, String userpwd, Integer rid, Integer dtype, String dtime) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpwd = userpwd;
		this.rid = rid;
		this.dtype = dtype;
		this.dtime = dtime;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public Integer getRid() {
		return rid;
	}

	public Users() {
		super();
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Users(Integer userid, String username, String userpwd, Integer rid) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpwd = userpwd;
		this.rid = rid;
	}

	@Override
	public String toString() {
		return "Users [userid=" + userid + ", username=" + username + ", userpwd=" + userpwd + ", rid=" + rid + "]";
	}

}
