package com.accp.pojo;
/**
 * 
* <p>Title: Province</p>  
* <p>Description:省份实体类 </p>  
* @author Apple 

* @date 2019年5月13日
 */
public class Province {
	private String province_name;//省份名称
	private Integer province_id;//省份编号
	public String getProvince_name() {
		return province_name;
	}
	public void setProvince_name(String province_name) {
		this.province_name = province_name;
	}
	public Integer getProvince_id() {
		return province_id;
	}
	public void setProvince_id(Integer province_id) {
		this.province_id = province_id;
	}
	@Override
	public String toString() {
		return "Province [province_name=" + province_name + ", province_id=" + province_id + "]";
	}
	public Province() {
		
	}
	
}
