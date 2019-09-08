package com.accp.annotation.entity;

import com.accp.annotation.dao.Column;
import com.accp.annotation.dao.Table;

@Table("book")
public class BookInfo {
	@Column(name="b_id",isPrimaryKey=true,isIdentity=true,type="int",isNull=false)
	private Integer bid;
	@Column(name="b_name")
	private String bname;
	@Column(name="b_author")
	private String bauthor;

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	public BookInfo(String bname, String bauthor) {
		super();
		this.bname = bname;
		this.bauthor = bauthor;
	}

	public BookInfo() {
		super();
	}

	@Override
	public String toString() {
		return "BookInfo [bid=" + bid + ", bname=" + bname + ", bauthor=" + bauthor + "]";
	}

}
