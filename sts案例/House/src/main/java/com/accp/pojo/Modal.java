package com.accp.pojo;

/**
 * 
* <p>Title: Modal</p>  
* <p>Description:出租方式实体类 </p>  
* @author Apple 

* @date 2019年5月13日
 */
public class Modal {
	private Integer modal_id;//出租方式编号
	private String modal_type;//出租方式
	public Modal() {
		super();
	}
	@Override
	public String toString() {
		return "Modal [modal_id=" + modal_id + ", modal_type=" + modal_type + "]";
	}
	public Integer getModal_id() {
		return modal_id;
	}
	public void setModal_id(Integer modal_id) {
		this.modal_id = modal_id;
	}
	public String getModal_type() {
		return modal_type;
	}
	public void setModal_type(String modal_type) {
		this.modal_type = modal_type;
	}
}
