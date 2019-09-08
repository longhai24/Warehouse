package com.accp.t3.pojo;

public class Address {

	private Integer addressId;
	private String addressName;
	private String addressTel;

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getAddressTel() {
		return addressTel;
	}

	public void setAddressTel(String addressTel) {
		this.addressTel = addressTel;
	}

	public Address(String addressName, String addressTel) {
		super();
		this.addressName = addressName;
		this.addressTel = addressTel;
	}

	public Address() {
		super();
	}
}
