package com.accp.entity;

import com.accp.annotation.Column;
import com.accp.annotation.Table;

@Table("member")
public class MemberInfo {

	@Column(name = "id", type = "int", length = 6, isPrimaryKey = true, isNull = false, isIdentity = true)
	private Integer memberId;
	@Column(name = "username", type = "varchar", length = 20, isNull = true)
	private String memberName;
	@Column(name = "upwd", type = "int", length = 20, isNull = true)
	private String memberPwd;

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public MemberInfo(Integer memberId, String memberName, String memberPwd) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberPwd = memberPwd;
	}

	public MemberInfo(String memberName, String memberPwd) {
		super();
		this.memberName = memberName;
		this.memberPwd = memberPwd;
	}

	public MemberInfo() {
		super();
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberName=" + memberName + ", memberPwd=" + memberPwd + "]";
	}

}
