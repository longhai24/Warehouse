package com.accp.Goods.entity;

/**
 * 
* <p>Title: Productdescription</p>  
* <p>Description: ��Ʒʵ����</p>  
* @author Apple 

* @date 2019��4��9��
 */
public class Productdescription {
	private String pid;//��Ʒ���
	private String pname;//��Ʒ����
	private String ptype;//��Ʒ����
	private Float pprice;//��Ʒ�۸�
	private String pimg;//��ƷͼƬ
	private String pflag;//�̱�
	
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public Float getPprice() {
		return pprice;
	}
	public void setPprice(Float pprice) {
		this.pprice = pprice;
	}
	public String getPimg() {
		return pimg;
	}
	public void setPimg(String pimg) {
		this.pimg = pimg;
	}
	public String getPflag() {
		return pflag;
	}
	public void setPflag(String pflag) {
		this.pflag = pflag;
	}
	public Productdescription(String pid, String pname, String ptype, Float pprice, String pimg, String pflag) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.ptype = ptype;
		this.pprice = pprice;
		this.pimg = pimg;
		this.pflag = pflag;
	}
	
	public Productdescription() {
		super();
	}
	@Override
	public String toString() {
		return "Productdescription [pid=" + pid + ", pname=" + pname + ", ptype=" + ptype + ", pprice=" + pprice
				+ ", pimg=" + pimg + ", pflag=" + pflag + "]";
	}
	
}
