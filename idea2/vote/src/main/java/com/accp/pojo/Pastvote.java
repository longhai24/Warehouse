package com.accp.pojo;

public class Pastvote {
	private Integer pvid; //标号
	private user u; //发布人
	private String voption; //问题选项
	private String vid; //问题编号

	public String getVid() {
		return vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}

	public Integer getPvid() {
		return pvid;
	}
	public void setPvid(Integer pvid) {
		this.pvid = pvid;
	}
	public user getU() {
		return u;
	}
	public void setU(user u) {
		this.u = u;
	}
	public String getVoption() {
		return voption;
	}
	public void setVoption(String voption) {
		this.voption = voption;
	}
	public Pastvote() {
		super();
	}

	@Override
	public String toString() {
		return "Pastvote{" +
				"pvid=" + pvid +
				", u=" + u +
				", voption='" + voption + '\'' +
				'}';
	}
}
