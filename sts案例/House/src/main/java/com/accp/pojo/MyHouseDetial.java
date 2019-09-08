package com.accp.pojo;

/**
 * 
* <p>Title: MyHouseDetial</p>  
* <p>Description:商品详情类 </p>  
* @author Apple 

* @date 2019年5月18日
 */
public class MyHouseDetial {
	private String htil;
	private String hdate;
	private String tname;
	private String hare;
	private String pname;
	private String dname;
	private String hphone;
	private String hinf;
	private String sname;
	
	@Override
	public String toString() {
		return "MyHouseDetial [htil=" + htil + ", hdate=" + hdate + ", tname=" + tname + ", hare=" + hare + ", pname="
				+ pname + ", dname=" + dname + ", hphone=" + hphone + ", hinf=" + hinf + ", sname=" + sname + "]";
	}
	public MyHouseDetial() {
		super();
	}
	public String getHtil() {
		return htil;
	}
	public void setHtil(String htil) {
		this.htil = htil;
	}
	public String getHdate() {
		return hdate;
	}
	public void setHdate(String hdate) {
		this.hdate = hdate;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getHare() {
		return hare;
	}
	public void setHare(String hare) {
		this.hare = hare;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getHphone() {
		return hphone;
	}
	public void setHphone(String hphone) {
		this.hphone = hphone;
	}
	public String getHinf() {
		return hinf;
	}
	public void setHinf(String hinf) {
		this.hinf = hinf;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
}
