package com.accp.ajax.entity;

/**
 * 
* <p>Title: Staff</p>  
* <p>Description: Ա��ʵ�������</p>  
* @author Apple 

* @date 2019��4��9��
 */
public class Staff {
	
	private Integer sid;//Ա�����
	private String sname;//Ա������
	private String saddress;//Ա����ַ
	private String semail;//Ա������
	private Integer did;//���ű��
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public Staff(Integer sid, String sname, String saddress, String semail, Integer did) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.saddress = saddress;
		this.semail = semail;
		this.did = did;
	}
	@Override
	public String toString() {
		return "Staff [sid=" + sid + ", sname=" + sname + ", saddress=" + saddress + ", semail=" + semail + ", did="
				+ did + "]";
	}
	
}
