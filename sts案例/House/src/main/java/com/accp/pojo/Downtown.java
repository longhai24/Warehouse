package com.accp.pojo;
/**
 * 
* <p>Title: Downtown</p>  
* <p>Description:市区实体类 </p>  
* @author Apple 

* @date 2019年5月13日
 */
public class Downtown {
	private Integer province_id;//省份编号
	private String downtown_name;//市区名称
	private Integer downtown_id;//市区编号
	public Integer getProvince_id() {
		return province_id;
	}
	public void setProvince_id(Integer province_id) {
		this.province_id = province_id;
	}
	public String getDowntown_name() {
		return downtown_name;
	}
	public void setDowntown_name(String downtown_name) {
		this.downtown_name = downtown_name;
	}
	public Integer getDowntown_id() {
		return downtown_id;
	}
	public void setDowntown_id(Integer downtown_id) {
		this.downtown_id = downtown_id;
	}
	@Override
	public String toString() {
		return "Downtown [province_id=" + province_id + ", downtown_name=" + downtown_name + ", downtown_id="
				+ downtown_id + "]";
	}
	public Downtown() {
		super();
	}
	
}
