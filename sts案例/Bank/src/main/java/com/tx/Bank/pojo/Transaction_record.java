package com.tx.Bank.pojo;

import java.util.Date;

/**
 * 
* <p>Title: Transaction_record</p>  
* <p>Description:交易记录实体类 </p>  
* @author Apple 

* @date 2019年5月24日
 */
public class Transaction_record {
	private Integer id;//记录id
	private String cardno;//卡号
	private Date transaction_date;//交易日期
	private Integer expense;//支出
	private Integer income;//存入
	private Integer balance;//账户余额
	private String transaction_type;//交易类型
	private String remark;//备注
	@Override
	public String toString() {
		return "Transaction_record [id=" + id + ", cardno=" + cardno + ", transaction_date=" + transaction_date
				+ ", expense=" + expense + ", income=" + income + ", balance=" + balance + ", transaction_type="
				+ transaction_type + ", remark=" + remark + "]";
	}
	public Transaction_record() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public Date getTransaction_date() {
		return transaction_date;
	}
	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}
	public Integer getExpense() {
		return expense;
	}
	public void setExpense(Integer expense) {
		this.expense = expense;
	}
	public Integer getIncome() {
		return income;
	}
	public void setIncome(Integer income) {
		this.income = income;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
