package com.tx.pojo;

/**
 * @description:航班实体类
 * @author: apple
 * @date: 2019-06-05 8:03
 */
public class FlightInfo {
    private Integer id;
    private  String flightId;
    private String company;
    private String leaveAirport;
    private String arriveAirport;
    private String leaveTime;
    private String arriveTime;
    private String airplane;

    public FlightInfo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLeaveAirport() {
        return leaveAirport;
    }

    public void setLeaveAirport(String leaveAirport) {
        this.leaveAirport = leaveAirport;
    }

    public String getArriveAirport() {
        return arriveAirport;
    }

    public void setArriveAirport(String arriveAirport) {
        this.arriveAirport = arriveAirport;
    }

    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getAirplane() {
        return airplane;
    }

    public void setAirplane(String airplane) {
        this.airplane = airplane;
    }
}
