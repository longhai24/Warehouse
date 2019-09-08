package com.accp.ajax.entity;

/**
 * 
 * <p>
 * Title: Staff
 * </p>
 * <p>
 * Description:ʵ����洢����
 * </p>
 * 
 * @author Apple
 * 
 * @date 2019��4��4��
 */
public class Staff {
	private Integer id;// ���
	private String name;// ����

	public Staff() {
		super();
	}

	public Staff(Integer id, String name, String site, String email) {
		super();
		this.id = id;
		this.name = name;
		this.site = site;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String site;// ��ַ
	private String email;// ����

	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", site=" + site + ", email=" + email + "]";
	}
}
