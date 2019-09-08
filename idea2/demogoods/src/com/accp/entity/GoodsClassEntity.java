package com.accp.entity;

public class GoodsClassEntity {
	private int goodsClassId;
	private String goodsClassName;
	public int getGoodsClassId() {
		return goodsClassId;
	}
	
	public void setGoodsClassId(int goodsClassId) {
		this.goodsClassId = goodsClassId;
	}
	public String getGoodsClassName() {
		return goodsClassName;
	}
	public void setGoodsClassName(String goodsClassName) {
		this.goodsClassName = goodsClassName;
	}
	public GoodsClassEntity(int goodsClassId, String goodsClassName) {
		super();
		this.goodsClassId = goodsClassId;
		this.goodsClassName = goodsClassName;
	}
	public GoodsClassEntity() {
		super();
	}
	public GoodsClassEntity(String goodsClassName) {
		super();
		this.goodsClassName = goodsClassName;
	}
	
}
