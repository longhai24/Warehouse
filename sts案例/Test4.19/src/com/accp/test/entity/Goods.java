package com.accp.test.entity;

/**
 * 
* <p>Title: Goods</p>  
* <p>Description:��Ʒʵ����</p>  
* @author Apple 

* @date 2019��4��19��
 */
public class Goods {

	private Integer goodsId;//��Ʒ���
	private String goodsType;//��Ʒ�ͺ�
	private String goodsName;//��Ʒ����
	private Integer goodsClassId;//��Ʒ���
	
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
	private float goodsPrice;//��Ʒ�۸�

	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsType=" + goodsType + ", goodsName=" + goodsName + ", goodsClassId="
				+ goodsClassId + ", goodsPrice=" + goodsPrice + "]";
	}
}
