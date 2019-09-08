package com.accp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Bill;

public interface IbillDao {
	//查询
	public Bill selectAll(@Param("billno") String name);
	//删除
	public int delete(@Param("billno") Integer noid);
}
