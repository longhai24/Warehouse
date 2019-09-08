package com.accp.pojo;
/**
 * 
* <p>Title: Type</p>  
* <p>Description:房屋类型实体类 </p>  
* @author Apple 

* @date 2019年5月13日
 */
public class Type {
	private Integer type_id;//房屋类型编号
	private String type_name;//房屋类型
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public Type() {
		super();
	}
	
	
}
