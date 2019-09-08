package pojo;

import java.util.Date;
import java.util.List;

public class tb_bill {

	private String billno;
	private String suppliername;
	private String supplieraddress;
	private String department;
	private String warehouse;
	private String buyer;
	private String executor;
	private Date billdate;
	private List<tb_detail> bill;
	
	public List<tb_detail> getBill() {
		return bill;
	}
	public void setBill(List<tb_detail> bill) {
		this.bill = bill;
	}
	public String getBillno() {
		return billno;
	}
	public void setBillno(String billno) {
		this.billno = billno;
	}
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	public String getSupplieraddress() {
		return supplieraddress;
	}
	public void setSupplieraddress(String supplieraddress) {
		this.supplieraddress = supplieraddress;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getExecutor() {
		return executor;
	}
	public void setExecutor(String executor) {
		this.executor = executor;
	}
	public Date getBilldate() {
		return billdate;
	}
	public void setBilldate(Date billdate) {
		this.billdate = billdate;
	}
	public tb_bill() {
		super();
	}
	@Override
	public String toString() {
		return "tb_bill [billno=" + billno + ", suppliername=" + suppliername + ", supplieraddress=" + supplieraddress
				+ ", department=" + department + ", warehouse=" + warehouse + ", buyer=" + buyer + ", executor="
				+ executor + ", billdate=" + billdate + ", bill=" + bill + "]";
	}

	
}
