package com.accp.pojo;

public class Detail {
	private Bill bill;
	private Integer lineid;
	private String goodsname;
	private Integer goodsnum;
	private float goodsprice;
	private float goodsmoneyamt;
	private Integer ispresent;
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	public Integer getLineid() {
		return lineid;
	}
	public void setLineid(Integer lineid) {
		this.lineid = lineid;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public Integer getGoodsnum() {
		return goodsnum;
	}
	public void setGoodsnum(Integer goodsnum) {
		this.goodsnum = goodsnum;
	}
	public float getGoodsprice() {
		return goodsprice;
	}
	public void setGoodsprice(float goodsprice) {
		this.goodsprice = goodsprice;
	}
	public float getGoodsmoneyamt() {
		return goodsmoneyamt;
	}
	public void setGoodsmoneyamt(float goodsmoneyamt) {
		this.goodsmoneyamt = goodsmoneyamt;
	}
	public Integer getIspresent() {
		return ispresent;
	}
	public void setIspresent(Integer ispresent) {
		this.ispresent = ispresent;
	}
	@Override
	public String toString() {
		return "Detail [bill=" + bill + ", lineid=" + lineid + ", goodsname=" + goodsname + ", goodsnum=" + goodsnum
				+ ", goodsprice=" + goodsprice + ", goodsmoneyamt=" + goodsmoneyamt + ", ispresent=" + ispresent + "]";
	}
	
}
