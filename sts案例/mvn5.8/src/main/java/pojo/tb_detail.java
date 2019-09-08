package pojo;

public class tb_detail {

	private String billno;
	private Integer lineid;
	private Integer goodsnum;
	private Integer ispresent ;
	private String goodsname;
	private float goodsprice;
	private float goodsmoneyamt;
	private tb_bill bill;
	
	public tb_bill getBill() {
		return bill;
	}
	public void setBill(tb_bill bill) {
		this.bill = bill;
	}
	public String getBillno() {
		return billno;
	}
	public void setBillno(String billno) {
		this.billno = billno;
	}
	public Integer getLineid() {
		return lineid;
	}
	public void setLineid(Integer lineid) {
		this.lineid = lineid;
	}
	public Integer getGoodsnum() {
		return goodsnum;
	}
	public void setGoodsnum(Integer goodsnum) {
		this.goodsnum = goodsnum;
	}
	public Integer getIspresent() {
		return ispresent;
	}
	public void setIspresent(Integer ispresent) {
		this.ispresent = ispresent;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
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
	public tb_detail() {
		super();
	}
	@Override
	public String toString() {
		return "tb_detail [billno=" + billno + ", lineid=" + lineid + ", goodsnum=" + goodsnum + ", ispresent="
				+ ispresent + ", goodsname=" + goodsname + ", goodsprice=" + goodsprice + ", goodsmoneyamt="
				+ goodsmoneyamt + "]";
	}
	
}
