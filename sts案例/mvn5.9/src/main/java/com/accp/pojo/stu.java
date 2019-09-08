package com.accp.pojo;

/**
* <p>Title: stu</p>  
* <p>Description:学生实体 </p>  
* @author Apple 

* @date 2019年5月9日
 */
public class stu {

	private int stuid;
	private String stuname;
	private String stunum;
	private String stusex;
	private Integer clazzid;
	private clazz cla;
	public int getStuid() {
		return stuid;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public String getStunum() {
		return stunum;
	}
	public void setStunum(String stunum) {
		this.stunum = stunum;
	}
	public String getStusex() {
		return stusex;
	}
	public void setStusex(String stusex) {
		this.stusex = stusex;
	}
	public Integer getClazzid() {
		return clazzid;
	}
	public void setClazzid(Integer clazzid) {
		this.clazzid = clazzid;
	}
	public clazz getCla() {
		return cla;
	}
	public void setCla(clazz cla) {
		this.cla = cla;
	}
	public stu() {
		super();
	}
	@Override
	public String toString() {
		return "stu [stuid=" + stuid + ", stuname=" + stuname + ", stunum=" + stunum + ", stusex=" + stusex
				+ ", clazzid=" + clazzid + ", cla=" + cla + "]";
	}
	
}
