package cpm.accp.ping.entity;

import java.util.Date;

public class Use {
	private Integer userid; 
	private String username;
	private String userpwd;
	private Role ro;
	private String rid;
	private int uzing;
	private String ztime;
	
	public String getZtime() {
		return ztime;
	}
	public void setZtime(String ztime) {
		this.ztime = ztime;
	}
	public int getUzing() {
		return uzing;
	}
	public void setUzing(int uzing) {
		this.uzing = uzing;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
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
	public Role getRo() {
		return ro;
	}
	public void setRo(Role ro) {
		this.ro = ro;
	}
	public Use(Integer userid, String username, String userpwd, Role ro) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpwd = userpwd;
		this.ro = ro;
	}
	public Use() {
		super();
	}
	public Use(String username, String userpwd, Role ro) {
		super();
		this.username = username;
		this.userpwd = userpwd;
		this.ro = ro;
	}
	public Use(Integer userid, String username, String userpwd, Role ro, int uzing, String ztime) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpwd = userpwd;
		this.ro = ro;
		this.uzing = uzing;
		this.ztime = ztime;
	}
	public Use(String username, String userpwd, Role ro, String rid, int uzing, String ztime) {
		super();
		this.username = username;
		this.userpwd = userpwd;
		this.ro = ro;
		this.rid = rid;
		this.uzing = uzing;
		this.ztime = ztime;
	}
	
	
	
}
