package com.accp.entity;

import com.accp.dao.Column;
import com.accp.dao.Table;

@Table("dep")
public class depp {
	@Column(name="id",isPrimaryKey=true,isIdentity=true,type="int",isNull=false)
	private int idd;
	@Column(name="name",isPrimaryKey=false,isIdentity=false,type="varchar",isNull=false)
	private String named;
	@Column(name="add",isPrimaryKey=false,isIdentity=false,type="varchar",isNull=false)
	private String addd;
	public int getIdd() {
		return idd;
	}
	public void setIdd(int idd) {
		this.idd = idd;
	}
	public String getNamed() {
		return named;
	}
	public void setNamed(String named) {
		this.named = named;
	}
	public String getAddd() {
		return addd;
	}
	public void setAddd(String addd) {
		this.addd = addd;
	}
	public depp(int idd, String named, String addd) {
		super();
		this.idd = idd;
		this.named = named;
		this.addd = addd;
	}
	public depp() {
		super();
	}
	
}
