package com.accp.test.entity;

/**
 * 
* <p>Title: GoodsClass</p>  
* <p>Description:��Ʒ����ʵ���� </p>  
* @author Apple 

* @date 2019��4��19��
 */
public class GoodsClass {

	private Integer goodsClassId;//��Ʒ���ͱ��
	
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
	private String goodsClassName;//��Ʒ��������

	@Override
	public String toString() {
		return "GoodsClass [goodsClassId=" + goodsClassId + ", goodsClassName=" + goodsClassName + "]";
	}
}
