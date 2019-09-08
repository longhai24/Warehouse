package com.accp.test.entity;

/**
 * 
* <p>Title: GoodsClass</p>  
* <p>Description:商品类型实体类 </p>  
* @author Apple 

* @date 2019年4月19日
 */
public class GoodsClass {

	private Integer goodsClassId;//商品类型编号
	
	public GoodsClass() {
		super();
	}
	public Integer getGoodsClassId() {
		return goodsClassId;
	}
	public void setGoodsClassId(Integer goodsClassId) {
		this.goodsClassId = goodsClassId;
	}
	public String getGoodsClassName() {
		return goodsClassName;
	}
	public void setGoodsClassName(String goodsClassName) {
		this.goodsClassName = goodsClassName;
	}
	private String goodsClassName;//商品类型名称

	@Override
	public String toString() {
		return "GoodsClass [goodsClassId=" + goodsClassId + ", goodsClassName=" + goodsClassName + "]";
	}
}
