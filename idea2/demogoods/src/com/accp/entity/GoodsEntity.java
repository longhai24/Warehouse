package com.accp.entity;

public class GoodsEntity {
	private Integer goodsid;
	private String goodsName;
	private String goodsType;
	private GoodsClassEntity glzz;
	private float goodsPrice;
	private int goodsclazzid;
	
	public int getGoodsclazzid() {
		return goodsclazzid;
	}
	public void setGoodsclazzid(int goodsclazzid) {
		this.goodsclazzid = goodsclazzid;
	}
	public Integer getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public GoodsClassEntity getGlzz() {
		return glzz;
	}
	public void setGlzz(GoodsClassEntity glzz) {
		this.glzz = glzz;
	}
	public float getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	
	public GoodsEntity() {
		super();
	}
	public GoodsEntity(Integer goodsid, String goodsName, String goodsType, GoodsClassEntity glzz, float goodsPrice) {
		super();
		this.goodsid = goodsid;
		this.goodsName = goodsName;
		this.goodsType = goodsType;
		this.glzz = glzz;
		this.goodsPrice = goodsPrice;
	}
	public GoodsEntity(String goodsName, String goodsType, GoodsClassEntity glzz, float goodsPrice) {
		super();
		this.goodsName = goodsName;
		this.goodsType = goodsType;
		this.glzz = glzz;
		this.goodsPrice = goodsPrice;
	}
	
}
