package com.accp.dao;

import com.accp.pojo.FlightInfo;

import java.util.List;

public interface IFDao {
    public List<FlightInfo> find();
}
