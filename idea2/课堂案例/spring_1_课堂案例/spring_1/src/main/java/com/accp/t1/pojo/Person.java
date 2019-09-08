package com.accp.t1.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Person {

	private Integer pid;
	private String pname;
	private Integer psex;
	private Date pdate;
	private String pimg;
	
	private List<String> loves;

	private List<Address> addresses;

	public List<String> getLoves() {
		return loves;
	}

	public void setLoves(List<String> loves) {
		this.loves = loves;
	}

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

	public void init() {
		this.setPid(10000);
		this.setPname("芙蓉姐");
		this.setPsex(1);
		this.setPdate(new Date());
		this.setPimg("fu.jpg");
		List<String> loves = new ArrayList<String>();
		loves.add("逛街");
		loves.add("睡觉");
		this.setLoves(loves);
		List<Address> addresses = new ArrayList<Address>();
		addresses.add(new Address("湖南长沙", "1383838438"));
		addresses.add(new Address("湖南湘潭", "137......."));
		this.setAddresses(addresses);
	}
	
	public void printMessage() {
		System.out.println("姓名:" + this.getPname());
		System.out.println("性别:" + (this.getPsex() == 0 ? "男" : "女"));
		System.out.println("生日:" + this.getPdate().toLocaleString());
		System.out.print("爱好:");
		for (String love : this.getLoves()) {
			System.out.print(love + "\t");
		}
		System.out.print("\n收货地址:");
		for (Address address : this.getAddresses()) {
			System.out.print(address.getAname() + "\t");
		}
	}

}
