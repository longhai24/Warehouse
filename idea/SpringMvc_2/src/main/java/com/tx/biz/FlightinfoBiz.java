package com.tx.biz;

import com.tx.dao.FlightInfoDao;
import com.tx.pojo.FlightInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:业务逻辑操作层
 * @author: apple
 * @date: 2019-06-05 8:45
 */
@Service
public class FlightinfoBiz {
    @Autowired
    private FlightInfoDao fDao;


    public List<FlightInfo> selSome(String sid){
        return fDao.selSome(sid) ;
    }
}
