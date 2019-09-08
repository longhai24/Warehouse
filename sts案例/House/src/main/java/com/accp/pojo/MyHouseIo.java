package com.accp.pojo;

public class MyHouseIo {

	private Integer hid;//房屋编号
	private String htit;//房屋标题
	private String hpho;//联系电话
	private String hpic;//房屋图片
	private String hinf;//房屋内容
	public String getHinf() {
		return hinf;
	}
	public void setHinf(String hinf) {
		this.hinf = hinf;
	}
	@Override
	public String toString() {
		return "MyHouseIo [hid=" + hid + ", htit=" + htit + ", hpho=" + hpho + ", hpic=" + hpic + "]";
	}
	public MyHouseIo() {
		super();
	}
	public Integer getHid() {
		return hid;
	}
	public void setHid(Integer hid) {
		this.hid = hid;
	}
	public String getHtit() {
		return htit;
	}
	public void setHtit(String htit) {
		this.htit = htit;
	}
	public String getHpho() {
		return hpho;
	}
	public void setHpho(String hpho) {
		this.hpho = hpho;
	}
	public String getHpic() {
		return hpic;
	}
	public void setHpic(String hpic) {
		this.hpic = hpic;
	}
}
