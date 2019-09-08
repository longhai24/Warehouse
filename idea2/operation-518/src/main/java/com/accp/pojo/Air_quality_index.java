package com.accp.pojo;

public class Air_quality_index {
	private Integer id;
	private District district_id;
	private String monitor_time ;
	private Integer pm10;
	private Integer pm25;
	private String monitoring_station;
	private String last_modify_time;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public District getDistrict_id() {
		return district_id;
	}
	public void setDistrict_id(District district_id) {
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
	public Integer getPm25() {
		return pm25;
	}
	public void setPm25(Integer pm25) {
		this.pm25 = pm25;
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
	@Override
	public String toString() {
		return "Air_quality_index [id=" + id + ", district_id=" + district_id + ", monitor_time=" + monitor_time
				+ ", pm10=" + pm10 + ", pm25=" + pm25 + ", monitoring_station=" + monitoring_station
				+ ", last_modify_time=" + last_modify_time + "]";
	}
	
	
}
