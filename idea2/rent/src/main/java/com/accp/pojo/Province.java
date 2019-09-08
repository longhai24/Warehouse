package com.accp.pojo;

import java.util.List;

public class Province {
	private Integer pid;
	private String pname;
	private List<City> citys;
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
	public List<City> getCitys() {
		return citys;
	}
	public void setCitys(List<City> citys) {
		this.citys = citys;
	}
	
	public Province() {
		super();
	}
	@Override
	public String toString() {
		return "Province [pid=" + pid + ", pname=" + pname + ", citys=" + citys + "]";
	}
	
	
}
