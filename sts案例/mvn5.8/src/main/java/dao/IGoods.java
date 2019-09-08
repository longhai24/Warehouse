package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.tb_bill;

public interface IGoods {

	//根据订单编号查询
	public List<tb_bill>  SelAllBillByBillno(@Param("selno")String selno);
	//根据订单编号删除
	public Integer DelByBillno(@Param("delNo")String delno);
}
