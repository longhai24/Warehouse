package com.accp.pojo;

/**
 * 
* <p>Title: Condition</p>  
* <p>Description:条件视图类 </p>  
* @author Apple 

* @date 2019年5月18日
 */
public class Condition {

	private String title;
	private String money;
	private String province_id;
	private String downtown_id;
	private String street_id;
	private String type;
	@Override
	public String toString() {
		return "Condition [title=" + title + ", money=" + money + ", province_id=" + province_id + ", downtown_id="
				+ downtown_id + ", street_id=" + street_id + ", type=" + type + "]";
	}
	public Condition() {
		super();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getProvince_id() {
		return province_id;
	}
	public void setProvince_id(String province_id) {
		this.province_id = province_id;
	}
	public String getDowntown_id() {
		return downtown_id;
	}
	public void setDowntown_id(String downtown_id) {
		this.downtown_id = downtown_id;
	}
	public String getStreet_id() {
		return street_id;
	}
	public void setStreet_id(String street_id) {
		this.street_id = street_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
