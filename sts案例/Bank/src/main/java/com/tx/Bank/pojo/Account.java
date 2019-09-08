package com.tx.Bank.pojo;

/**
 * 
* <p>Title: Account</p>  
* <p>Description:账户信息实体类 </p>  
* @author Apple 

* @date 2019年5月24日
 */
public class Account {
	private String cardno;//卡号
	private String password;//密码
	private Integer balance;//账户余额
	private Integer status;//账户状态
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Account() {
		super();
	}
	@Override
	public String toString() {
		return "Account [cardno=" + cardno + ", password=" + password + ", balance=" + balance + ", status=" + status
				+ "]";
	}
	
}
