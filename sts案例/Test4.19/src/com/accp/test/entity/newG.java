package com.accp.test.entity;

/**
 * 
* <p>Title: newG</p>  
* <p>Description:实体io类 </p>  
* @author Apple 

* @date 2019年4月19日
 */
public class newG {
	private Integer goodsId;//商品编号
	private String goodsType;//商品型号
	private String goodsName;//商品名称
	private String goodsClassName;//商品类型名称
	private float goodsPrice;//商品价格
	public newG() {
		super();
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsClassName() {
		return goodsClassName;
	}
	public void setGoodsClassName(String goodsClassName) {
		this.goodsClassName = goodsClassName;
	}
	public float getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	@Override
	public String toString() {
		return "newG [goodsId=" + goodsId + ", goodsType=" + goodsType + ", goodsName=" + goodsName
				+ ", goodsClassName=" + goodsClassName + ", goodsPrice=" + goodsPrice + ", getGoodsId()=" + getGoodsId()
				+ ", getGoodsType()=" + getGoodsType() + ", getGoodsName()=" + getGoodsName() + ", getGoodsClassName()="
				+ getGoodsClassName() + ", getGoodsPrice()=" + getGoodsPrice() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
