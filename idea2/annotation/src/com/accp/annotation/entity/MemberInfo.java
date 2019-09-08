package com.accp.annotation.entity;

import com.accp.annotation.dao.Column;
import com.accp.annotation.dao.Table;

@Table("Member")
public class MemberInfo {
	@Column(name="id",isPrimaryKey=true,isIdentity=true,type="int",isNull=false)
	private Integer memberId;
	private String memberName;
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
