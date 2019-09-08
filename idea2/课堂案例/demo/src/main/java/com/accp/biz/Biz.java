package com.accp.biz;

import com.accp.dao.IFDao;
import com.accp.pojo.FlightInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Biz {
    @Autowired
    private IFDao dao;

    public List<FlightInfo> find(){
        return dao.find();
    }
}
