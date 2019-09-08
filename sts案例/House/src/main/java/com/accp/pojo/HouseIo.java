package com.accp.pojo;


public class HouseIo {

	private Integer hid;//房屋编号
	private String htit;//房屋标题
	private String mname;//房屋类型
	private Float hpri;//房屋价格
	private String hpho;//联系电话
	private String hpic;//房屋图片
	private String hinf;//房屋内容
	public String getHinf() {
		return hinf;
	}
	public void setHinf(String hinf) {
		this.hinf = hinf;
	}
	public HouseIo() {
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
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public Float getHpri() {
		return hpri;
	}
	public void setHpri(Float hpri) {
		this.hpri = hpri;
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
	@Override
	public String toString() {
		return "HouseIo [hid=" + hid + ", htit=" + htit + ", mname=" + mname + ", hpri=" + hpri + ", hpho=" + hpho
				+ ", hpic=" + hpic + ", hinf=" + hinf + "]";
	}
	public void setHpic(String hpic) {
		this.hpic = hpic;
	}
	
	
}
