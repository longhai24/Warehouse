package com.accp.test.entity;

/**
 * 
* <p>Title: Goods</p>  
* <p>Description:商品实体类</p>  
* @author Apple 

* @date 2019年4月19日
 */
public class Goods {

	private Integer goodsId;//商品编号
	private String goodsType;//商品型号
	private String goodsName;//商品名称
	private Integer goodsClassId;//商品编号
	
	public Goods() {
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
	public Integer getGoodsClassId() {
		return goodsClassId;
	}
	public void setGoodsClassId(Integer goodsClassId) {
		this.goodsClassId = goodsClassId;
	}
	public float getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	private float goodsPrice;//商品价格

	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsType=" + goodsType + ", goodsName=" + goodsName + ", goodsClassId="
				+ goodsClassId + ", goodsPrice=" + goodsPrice + "]";
	}
}
