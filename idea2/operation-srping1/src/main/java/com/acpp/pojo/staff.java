package com.acpp.pojo;

import java.util.List;

public class staff {
	private String name;
	private String sex;
	private String time;
	private List<String> interest;
	
	public staff(String name, String sex, String time, List<String> interest) {
		super();
		this.name = name;
		this.sex = sex;
		this.time = time;
		this.interest = interest;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<String> getInterest() {
		return interest;
	}

	public void setInterest(List<String> interest) {
		this.interest = interest;
	}

	public staff() {
		super();
	}

	@Override
	public String toString() {
		return "staff [name=" + name + ", sex=" + sex + ", time=" + time + ", interest=" + interest + "]";
	}
	
}
