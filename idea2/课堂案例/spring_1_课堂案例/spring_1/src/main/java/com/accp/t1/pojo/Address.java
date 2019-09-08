package com.accp.t1.pojo;

public class Address {

	private Integer aid;
	private String aname;
	private String atel;
	
	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getAtel() {
		return atel;
	}

	public void setAtel(String atel) {
		this.atel = atel;
	}

	public Address() {
		super();
	}
	

	public Address(String aname, String atel) {
		super();
		this.aname = aname;
		this.atel = atel;
	}

}
