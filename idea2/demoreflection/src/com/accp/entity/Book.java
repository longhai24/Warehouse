package com.accp.entity;

import com.accp.dao.Column;
import com.accp.dao.Table;

@Table("Book")
public class Book {
	@Column(name="b_id",isPrimaryKey=true,isIdentity=true,type="int",isNull=false)
	private Integer b_id;
	@Column(name="b_name",isPrimaryKey=false,isIdentity=false,type="varchar",isNull=false)
	private String b_name;
	@Column(name="b_author",isPrimaryKey=false,isIdentity=false,type="varchar",isNull=false)
	private String b_author;

	public Book(Integer b_id, String b_name, String b_author) {
		super();
		this.b_id = b_id;
		this.b_name = b_name;
		this.b_author = b_author;
	}

	public Book() {
		super();
	}

	public Integer getB_id() {
		return b_id;
	}

	public void setB_id(Integer b_id) {
		this.b_id = b_id;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public String getB_author() {
		return b_author;
	}

	public void setB_author(String b_author) {
		this.b_author = b_author;
	}

	@Override
	public String toString() {
		return "Book [b_id=" + b_id + ", b_name=" + b_name + ", b_author=" + b_author + "]";
	}
	
	

}
