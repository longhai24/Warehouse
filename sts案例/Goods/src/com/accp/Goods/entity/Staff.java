package com.accp.Goods.entity;
/**
 * 
* <p>Title: Staff</p>  
* <p>Description:��ɫʵ���� </p>  
* @author Apple 

* @date 2019��4��9��
 */
public class Staff {
	private Integer rid ;//��ɫ���
	private String rname;//��ɫ����
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
