package com.accp.Goods.entity;
/**
 * 
* <p>Title: Staff</p>  
* <p>Description:角色实体类 </p>  
* @author Apple 

* @date 2019年4月9日
 */
public class Staff {
	private Integer rid ;//角色编号
	private String rname;//角色姓名
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
	public Staff(Integer rid, String rname) {
		super();
		this.rid = rid;
		this.rname = rname;
	}
	@Override
	public String toString() {
		return "Staff [rid=" + rid + ", rname=" + rname + "]";
	}
	
}
