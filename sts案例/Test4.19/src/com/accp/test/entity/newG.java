package com.accp.test.entity;

/**
 * 
* <p>Title: newG</p>  
* <p>Description:ʵ��io�� </p>  
* @author Apple 

* @date 2019��4��19��
 */
public class newG {
	private Integer goodsId;//��Ʒ���
	private String goodsType;//��Ʒ�ͺ�
	private String goodsName;//��Ʒ����
	private String goodsClassName;//��Ʒ��������
	private float goodsPrice;//��Ʒ�۸�
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
