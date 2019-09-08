package com.accp.t3.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class Person {

	private Integer pid;
	private String pname;
	private Integer psex;
	@JSONField(format = "yyyy-MM-dd")
	private Date pdate;
	private String pimg;

	private List<Address> addresses = new ArrayList<Address>(0);

	public Person(Integer pid, String pname, Integer psex, Date pdate, String pimg, List<Address> addresses) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.psex = psex;
		this.pdate = pdate;
		this.pimg = pimg;
		this.addresses = addresses;
	}

	public Person(Integer pid, String pname, Integer psex, Date pdate, String pimg) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.psex = psex;
		this.pdate = pdate;
		this.pimg = pimg;
	}

	public Person() {
		super();
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer getPsex() {
		return psex;
	}

	public void setPsex(Integer psex) {
		this.psex = psex;
	}

	public Date getPdate() {
		return pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	public String getPimg() {
		return pimg;
	}

	public void setPimg(String pimg) {
		this.pimg = pimg;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

}
