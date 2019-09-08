package com.accp.pojo;

public class Vote {
	private Integer vid; //编号
	private VotePail vp; //桶
	private String vissue; //问题
	private String vpoll; //总票数
	private String voptionA; //选项1
	private String voptionB;//选项2
	private String voptionC;//选项3
	private String voptionD;//选项4
	private String voptionE;//选项5
	public Integer getVid() {
		return vid;
	}
	public void setVid(Integer vid) {
		this.vid = vid;
	}
	public VotePail getVp() {
		return vp;
	}
	public void setVp(VotePail vp) {
		this.vp = vp;
	}
	public String getVissue() {
		return vissue;
	}
	public void setVissue(String vissue) {
		this.vissue = vissue;
	}
	public String getVpoll() {
		return vpoll;
	}
	public void setVpoll(String vpoll) {
		this.vpoll = vpoll;
	}
	public String getVoptionA() {
		return voptionA;
	}
	public void setVoptionA(String voptionA) {
		this.voptionA = voptionA;
	}
	public String getVoptionB() {
		return voptionB;
	}
	public void setVoptionB(String voptionB) {
		this.voptionB = voptionB;
	}
	public String getVoptionC() {
		return voptionC;
	}
	public void setVoptionC(String voptionC) {
		this.voptionC = voptionC;
	}
	public String getVoptionD() {
		return voptionD;
	}
	public void setVoptionD(String voptionD) {
		this.voptionD = voptionD;
	}
	public String getVoptionE() {
		return voptionE;
	}
	public void setVoptionE(String voptionE) {
		this.voptionE = voptionE;
	}
	public Vote() {
		super();
	}

	@Override
	public String toString() {
		return "Vote{" +
				"vid=" + vid +
				", vp=" + vp +
				", vissue='" + vissue + '\'' +
				", vpoll='" + vpoll + '\'' +
				", voptionA='" + voptionA + '\'' +
				", voptionB='" + voptionB + '\'' +
				", voptionC='" + voptionC + '\'' +
				", voptionD='" + voptionD + '\'' +
				", voptionE='" + voptionE + '\'' +
				'}';
	}
}
