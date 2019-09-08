package com.accp.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.List;

public class VotePail {
	private Integer vpid; //编号
	private Integer vpaction;//权限
	private String vpname; //桶名字
	private String vptrace; //介绍
	private user u; //用户
//	@JSONField(format = "YYYY-MM-DD")
	private Date vstarttime; //开始时间
//	@JSONField(format = "YYYY-MM-DD")
	private Date vdeadline; //截至时间
	private Integer vstatus; //状态
	private List<Vote> listVote; //该桶得所有问题
	private String vpa;//类型

	public String getVpa() {
		return vpa;
	}

	public void setVpa(String vpa) {
		this.vpa = vpa;
	}

	@Override
	public String toString() {
		return "VotePail{" +
				"vpid=" + vpid +
				", vpaction=" + vpaction +
				", vpname='" + vpname + '\'' +
				", vptrace='" + vptrace + '\'' +
				", u=" + u +
				", vstarttime=" + vstarttime +
				", vdeadline=" + vdeadline +
				", vstatus=" + vstatus +
				", listVote=" + listVote +
				'}';
	}

	public VotePail() {
	}

	public Integer getVpid() {
		return vpid;
	}

	public void setVpid(Integer vpid) {
		this.vpid = vpid;
	}

	public Integer getVpaction() {
		return vpaction;
	}

	public void setVpaction(Integer vpaction) {
		this.vpaction = vpaction;
	}

	public String getVpname() {
		return vpname;
	}

	public void setVpname(String vpname) {
		this.vpname = vpname;
	}

	public String getVptrace() {
		return vptrace;
	}

	public void setVptrace(String vptrace) {
		this.vptrace = vptrace;
	}

	public user getU() {
		return u;
	}

	public void setU(user u) {
		this.u = u;
	}

	public Date getVstarttime() {
		return vstarttime;
	}

	public void setVstarttime(Date vstarttime) {
		this.vstarttime = vstarttime;
	}

	public Date getVdeadline() {
		return vdeadline;
	}

	public void setVdeadline(Date vdeadline) {
		this.vdeadline = vdeadline;
	}

	public Integer getVstatus() {
		return vstatus;
	}

	public void setVstatus(Integer vstatus) {
		this.vstatus = vstatus;
	}

	public List<Vote> getListVote() {
		return listVote;
	}

	public void setListVote(List<Vote> listVote) {
		this.listVote = listVote;
	}
}
