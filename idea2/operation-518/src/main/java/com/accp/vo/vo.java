package com.accp.vo;

public class vo {
	private String id;
	private String time;
	private String p10;
	private String p25;
	private String zhan;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getP10() {
		return p10;
	}
	public void setP10(String p10) {
		this.p10 = p10;
	}
	public String getP25() {
		return p25;
	}
	public void setP25(String p25) {
		this.p25 = p25;
	}
	public String getZhan() {
		return zhan;
	}
	public void setZhan(String zhan) {
		this.zhan = zhan;
	}
	@Override
	public String toString() {
		return "vo [id=" + id + ", time=" + time + ", p10=" + p10 + ", p25=" + p25 + ", zhan=" + zhan + "]";
	}
	public vo(String id, String time, String p10, String p25, String zhan) {
		super();
		this.id = id;
		this.time = time;
		this.p10 = p10;
		this.p25 = p25;
		this.zhan = zhan;
	}
	public vo() {
		super();
	}
	
}
