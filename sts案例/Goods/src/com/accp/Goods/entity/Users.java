package com.accp.Goods.entity;

/**
 * 
 * <p>
 * Title: Users
 * </p>
 * <p>
 * Description: �û�ʵ����
 * </p>
 * 
 * @author Apple
 * 
 * @date 2019��4��9��
 */
public class Users {
	private Integer userid;// �û����
	private String username;// �û�����
	private String userpwd;// �û�����
	private Integer rid;// ��ɫid
	private Integer dtype;//ע��״̬
	private String dtime;//ע��ʱ��

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
