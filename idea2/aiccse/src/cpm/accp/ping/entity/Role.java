package cpm.accp.ping.entity;

public class Role {
	private Integer rid;
	private String rname;
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public Role(Integer rid, String rname) {
		super();
		this.rid = rid;
		this.rname = rname;
	}
	public Role(String rname) {
		super();
		this.rname = rname;
	}
	public Role() {
		super();
	}
	
}
