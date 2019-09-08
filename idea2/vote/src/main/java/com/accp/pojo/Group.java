package com.accp.pojo;

public class Group {
	private Integer gid; //编号
	private String gname; //组织名称
	private String gref; ///介绍
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getGref() {
		return gref;
	}
	public void setGref(String gref) {
		this.gref = gref;
	}
	public Group() {
		super();
	}

	@Override
	public String toString() {
		return "Group{" +
				"gid=" + gid +
				", gname='" + gname + '\'' +
				", gref='" + gref + '\'' +
				'}';
	}
}
