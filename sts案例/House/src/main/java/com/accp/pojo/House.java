package com.accp.pojo;

import java.util.Date;

/**
 * 
* <p>Title: House</p>  
* <p>Description:房屋实体类 </p>  
* @author Apple 

* @date 2019年5月15日
 */
public class House {

	private Integer house_id;//房屋编号
	private String house_title;//房屋标题
	private Integer type_id;//房屋类型编号
	private String House_area;//房屋面积
	private Float House_price;//房屋价格
	private Date House_date;//出租时间
	private String House_phone;//联系电话
	private String House_info;//房屋详情
	private Integer User_id;//出租人编号
	private Integer House_state;//房屋状态
	private String house_pic;//图片
	private Integer province_id;
	private Integer downtown_id;
	private Integer street_id;
	public Integer getProvince_id() {
		return province_id;
	}
	public void setProvince_id(Integer province_id) {
		this.province_id = province_id;
	}
	public Integer getDowntown_id() {
		return downtown_id;
	}
	public void setDowntown_id(Integer downtown_id) {
		this.downtown_id = downtown_id;
	}
	public Integer getStreet_id() {
		return street_id;
	}
	public void setStreet_id(Integer street_id) {
		this.street_id = street_id;
	}
	public String getHouse_pic() {
		return house_pic;
	}
	public void setHouse_pic(String house_pic) {
		this.house_pic = house_pic;
	}
	
	@Override
	public String toString() {
		return "House [house_id=" + house_id + ", house_title=" + house_title + ", type_id=" + type_id + ", House_area="
				+ House_area + ", House_price=" + House_price + ", House_date=" + House_date + ", House_phone="
				+ House_phone + ", House_info=" + House_info + ", User_id=" + User_id + ", House_state=" + House_state
				+ ", house_pic=" + house_pic + ", province_id=" + province_id + ", downtown_id=" + downtown_id
				+ ", street_id=" + street_id + "]";
	}
	public House() {
		super();
	}
	public Integer getHouse_id() {
		return house_id;
	}
	public void setHouse_id(Integer house_id) {
		this.house_id = house_id;
	}
	public String getHouse_title() {
		return house_title;
	}
	public void setHouse_title(String house_title) {
		this.house_title = house_title;
	}
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	public String getHouse_area() {
		return House_area;
	}
	public void setHouse_area(String house_area) {
		House_area = house_area;
	}
	public Float getHouse_price() {
		return House_price;
	}
	public void setHouse_price(Float house_price) {
		House_price = house_price;
	}
	public Date getHouse_date() {
		return House_date;
	}
	public void setHouse_date(Date house_date) {
		House_date = house_date;
	}
	public String getHouse_phone() {
		return House_phone;
	}
	public void setHouse_phone(String house_phone) {
		House_phone = house_phone;
	}
	public String getHouse_info() {
		return House_info;
	}
	public void setHouse_info(String house_info) {
		House_info = house_info;
	}
	public Integer getUser_id() {
		return User_id;
	}
	public void setUser_id(Integer user_id) {
		User_id = user_id;
	}
	public Integer getHouse_state() {
		return House_state;
	}
	public void setHouse_state(Integer house_state) {
		House_state = house_state;
	}
}
