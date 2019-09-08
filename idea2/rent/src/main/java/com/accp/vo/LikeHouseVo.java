package com.accp.vo;

public class LikeHouseVo {
	private String name; //名字
	private String minprice; //最小价格
	private String maxprice; //最大价格
	private String place; //城市
	private String street; //街区位置
	private String htype;//房类型
	private String acreage; //面积
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMinprice() {
		return minprice;
	}
	public void setMinprice(String minprice) {
		this.minprice = minprice;
	}
	public String getMaxprice() {
		return maxprice;
	}
	public void setMaxprice(String maxprice) {
		this.maxprice = maxprice;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getHtype() {
		return htype;
	}
	public void setHtype(String htype) {
		this.htype = htype;
	}
	public String getAcreage() {
		return acreage;
	}
	public void setAcreage(String acreage) {
		this.acreage = acreage;
	}

	public LikeHouseVo(String name, String minprice, String maxprice, String place, String street, String htype,
			String acreage) {
		super();
		this.name = name;
		this.minprice = minprice;
		this.maxprice = maxprice;
		this.place = place;
		this.street = street;
		this.htype = htype;
		this.acreage = acreage;
	}
	public LikeHouseVo() {
		super();
	}
	@Override
	public String toString() {
		return "LikeHouseVo [name=" + name + ", minprice=" + minprice + ", maxprice=" + maxprice + ", place=" + place
				+ ", street=" + street + ", htype=" + htype + ", acreage=" + acreage + "]";
	}
	
	
	
}
