package com.accp.pojo;

import java.util.Date;

public class AirInfo {
	private String id;
	private String flight_number;
	private String destination;
	private Date flight_date;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFlight_number() {
		return flight_number;
	}

	public void setFlight_number(String flight_number) {
		this.flight_number = flight_number;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getFlight_date() {
		return flight_date;
	}

	public void setFlight_date(Date flight_date) {
		this.flight_date = flight_date;
	}

	@Override
	public String toString() {
		return "AirInfo [id=" + id + ", flight_number=" + flight_number + ", destination=" + destination
				+ ", flight_date=" + flight_date + "]";
	}
	
}
