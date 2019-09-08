package com.accp.pojo;

import java.util.List;

/**
 * 
* <p>Title: clazz</p>  
* <p>Description:班级实体 </p>  
* @author Apple 

* @date 2019年5月9日
 */
public class clazz {
	private Integer id;
	private String clazzname;
	private List<stu> stulist;
	@Override
	public String toString() {
		return "clazz [id=" + id + ", clazzname=" + clazzname + ", stulist=" + stulist + "]";
	}
	public clazz() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClazzname() {
		return clazzname;
	}
	public void setClazzname(String clazzname) {
		this.clazzname = clazzname;
	}
	public List<stu> getStulist() {
		return stulist;
	}
	public void setStulist(List<stu> stulist) {
		this.stulist = stulist;
	}
}
