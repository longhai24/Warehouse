package com.accp.t2.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Person {

	private Integer personId;
	private String personName;
	private Integer personSex;
	private Date personDate;
	private String personImg;

	//建立关联关系（one-to-many）
	private List<Address> addresses=new ArrayList<Address>(0);
	
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Integer getPersonSex() {
		return personSex;
	}

	public void setPersonSex(Integer personSex) {
		this.personSex = personSex;
	}

	public Date getPersonDate() {
		return personDate;
	}

	public void setPersonDate(Date personDate) {
		this.personDate = personDate;
	}

	public String getPersonImg() {
		return personImg;
	}

	public void setPersonImg(String personImg) {
		this.personImg = personImg;
	}

	public Person(Integer personId, String personName, Integer personSex, Date personDate, String personImg) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.personSex = personSex;
		this.personDate = personDate;
		this.personImg = personImg;
	}

	public Person(String personName, Integer personSex, Date personDate, String personImg) {
		super();
		this.personName = personName;
		this.personSex = personSex;
		this.personDate = personDate;
		this.personImg = personImg;
	}

	public Person() {
		super();
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", personSex=" + personSex
				+ ", personDate=" + personDate + ", personImg=" + personImg + "]";
	}

}
