package com.accp.pojo;

/**
 * 
* <p>Title: Air_quality_index</p>  
* <p>Description: 空气质量指数实体类</p>  
* @author Apple 

* @date 2019年5月18日
 */
public class Air_quality_index {
	private String name;
	private Integer did;
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private  Integer id;
	private  Integer district_id;
	private  String monitor_time;
	private  Integer pm10;
	private  Integer pm2_5;
	private  String monitoring_station;
	public Air_quality_index() {
		super();
	}
	@Override
	public String toString() {
		return "Air_quality_index [id=" + id + ", district_id=" + district_id + ", monitor_time=" + monitor_time
				+ ", pm10=" + pm10 + ", pm2_5=" + pm2_5 + ", monitoring_station=" + monitoring_station
				+ ", last_modify_time=" + last_modify_time + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDistrict_id() {
		return district_id;
	}
	public void setDistrict_id(Integer district_id) {
		this.district_id = district_id;
	}
	public String getMonitor_time() {
		return monitor_time;
	}
	public void setMonitor_time(String monitor_time) {
		this.monitor_time = monitor_time;
	}
	public Integer getPm10() {
		return pm10;
	}
	public void setPm10(Integer pm10) {
		this.pm10 = pm10;
	}
	public Integer getPm2_5() {
		return pm2_5;
	}
	public void setPm2_5(Integer pm2_5) {
		this.pm2_5 = pm2_5;
	}
	public String getMonitoring_station() {
		return monitoring_station;
	}
	public void setMonitoring_station(String monitoring_station) {
		this.monitoring_station = monitoring_station;
	}
	public String getLast_modify_time() {
		return last_modify_time;
	}
	public void setLast_modify_time(String last_modify_time) {
		this.last_modify_time = last_modify_time;
	}
	private  String last_modify_time;
}
