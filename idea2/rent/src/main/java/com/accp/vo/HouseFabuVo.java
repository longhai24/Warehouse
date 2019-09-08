package com.accp.vo;

import com.accp.pojo.user;

public class HouseFabuVo {
	private String title ;
	private String himg  ;
	private String type_id ;
	private String floorage;
	private String price ;
	private String houseDate;
	private String street_id ;
	private String contact;
	private String description;
	private user u ;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHimg() {
		return himg;
	}
	public void setHimg(String himg) {
		this.himg = himg;
	}
	public String getType_id() {
		return type_id;
	}
	public void setType_id(String type_id) {
		this.type_id = type_id;
	}
	public String getFloorage() {
		return floorage;
	}
	public void setFloorage(String floorage) {
		this.floorage = floorage;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getHouseDate() {
		return houseDate;
	}
	public void setHouseDate(String houseDate) {
		this.houseDate = houseDate;
	}
	public String getStreet_id() {
		return street_id;
	}
	public void setStreet_id(String street_id) {
		this.street_id = street_id;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public user getU() {
		return u;
	}
	public void setU(user u) {
		this.u = u;
	}
	public HouseFabuVo(String title, String himg, String type_id, String floorage, String price, String houseDate,
			String street_id, String contact, String description, user u) {
		super();
		this.title = title;
		this.himg = himg;
		this.type_id = type_id;
		this.floorage = floorage;
		this.price = price;
		this.houseDate = houseDate;
		this.street_id = street_id;
		this.contact = contact;
		this.description = description;
		this.u = u;
	}
	
	public HouseFabuVo() {
		super();
	}
	@Override
	public String toString() {
		return "HouseFabuVo [title=" + title + ", himg=" + himg + ", type_id=" + type_id + ", floorage=" + floorage
				+ ", price=" + price + ", houseDate=" + houseDate + ", street_id=" + street_id + ", contact=" + contact
				+ ", description=" + description + ", u=" + u + "]";
	}
	
}
