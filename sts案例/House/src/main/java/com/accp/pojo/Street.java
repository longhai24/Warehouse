package com.accp.pojo;
/**
 * 
* <p>Title: Street</p>  
* <p>Description: 街道实体类</p>  
* @author Apple 

* @date 2019年5月13日
 */
public class Street {
	private String street_name;//街道名称
	private Integer street_id;//街道编号
	private Integer downtown_id;//市区编号
	public Integer getDowntown_id() {
		return downtown_id;
	}
	public void setDowntown_id(Integer downtown_id) {
		this.downtown_id = downtown_id;
	}
	public Street() {
		super();
	}
	@Override
	public String toString() {
		return "Street [street_name=" + street_name + ", street_id=" + street_id + ", downtown_id=" + downtown_id + "]";
	}
	public String getStreet_name() {
		return street_name;
	}
	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}
	public Integer getStreet_id() {
		return street_id;
	}
	public void setStreet_id(Integer street_id) {
		this.street_id = street_id;
	}
}
