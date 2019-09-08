package com.accp.t2.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;


public class Person {

	private Integer pid;
	private String pname;
	private Integer psex;
	@DateTimeFormat(pattern="yyyy-MM-dd")  //非常重要
	private Date pdate;
	private String pimg;

	private List<Address> addresses = new ArrayList<Address>(0);

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
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

	public void setPname(String name) {
		this.pname = name;
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

	public Person(Integer pid, String name, Integer psex, Date pdate, String pimg) {
		super();
		this.pid = pid;
		this.pname = name;
		this.psex = psex;
		this.pdate = pdate;
		this.pimg = pimg;
	}

	public Person() {
		super();
	}

	public Person(String pname, Integer psex, Date pdate, String pimg) {
		super();
		this.pname = pname;
		this.psex = psex;
		this.pdate = pdate;
		this.pimg = pimg;
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", psex=" + psex + ", pdate=" + pdate + ", pimg=" + pimg
				+ "]";
	}

}
