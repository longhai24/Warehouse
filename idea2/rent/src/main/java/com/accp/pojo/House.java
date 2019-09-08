package com.accp.pojo;

import java.util.Date;

import com.accp.vo.PlacevO;
import com.alibaba.fastjson.annotation.JSONField;

public class House {
	private Integer hid;
	private String htitle; //标题
	private HouseType Htype; //类型
	private String hacreage; //面积
	private String hprice; //价格
	private Date htime;//时间
	private PlacevO pla; //位置
	private String hphone;//电话
	private String hdetails; //详细
	private user u; //发布人z
	private String himg; //图片
	
	public House() {
		super();
	}
	public Integer getHid() {
		return hid;
	}
	public void setHid(Integer hid) {
		this.hid = hid;
	}
	public String getHtitle() {
		return htitle;
	}
	public void setHtitle(String htitle) {
		this.htitle = htitle;
	}
	public HouseType getHtype() {
		return Htype;
	}
	public void setHtype(HouseType htype) {
		Htype = htype;
	}
	public String getHacreage() {
		return hacreage;
	}
	public void setHacreage(String hacreage) {
		this.hacreage = hacreage;
	}
	public String getHprice() {
		return hprice;
	}
	public void setHprice(String hprice) {
		this.hprice = hprice;
	}
	public Date getHtime() {
		return htime;
	}
	public void setHtime(Date htime) {
		this.htime = htime;
	}
	public PlacevO getPla() {
		return pla;
	}
	public void setPla(PlacevO pla) {
		this.pla = pla;
	}
	public String getHphone() {
		return hphone;
	}
	public void setHphone(String hphone) {
		this.hphone = hphone;
	}
	public String getHdetails() {
		return hdetails;
	}
	public void setHdetails(String hdetails) {
		this.hdetails = hdetails;
	}
	public user getU() {
		return u;
	}
	public void setU(user u) {
		this.u = u;
	}
	public String getHimg() {
		return himg;
	}
	public void setHimg(String himg) {
		this.himg = himg;
	}
	
	@Override
	public String toString() {
		return "House [hid=" + hid + ", htitle=" + htitle + ", Htype=" + Htype + ", hacreage=" + hacreage + ", hprice="
				+ hprice + ", htime=" + htime + ", pla=" + pla + ", hphone=" + hphone + ", hdetails=" + hdetails
				+ ", u=" + u + ", himg=" + himg + "]";
	}
	public House(String htitle, HouseType htype, String hacreage, String hprice, Date htime, PlacevO pla, String hphone,
			String hdetails, user u, String himg) {
		super();
		this.htitle = htitle;
		Htype = htype;
		this.hacreage = hacreage;
		this.hprice = hprice;
		this.htime = htime;
		this.pla = pla;
		this.hphone = hphone;
		this.hdetails = hdetails;
		this.u = u;
		this.himg = himg;
	}
	
	
}
