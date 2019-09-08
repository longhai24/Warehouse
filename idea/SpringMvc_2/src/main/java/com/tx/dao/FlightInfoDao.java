package com.tx.dao;

import com.tx.pojo.FlightInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:对数据库访问
 * @author: apple
 * @date: 2019-06-05 8:41
 */
public interface FlightInfoDao {
    /**
     * @description: 根据id对航班进行查询
     * @author: apple
     * @date: 2019-06-05:44
     */
    public List<FlightInfo> selSome(@Param("sid") String sid);
}
