package com.accp.biz;

import java.util.ArrayList;

import com.accp.dao.GoodsDao;
import com.accp.entity.GoodsClassEntity;
import com.accp.entity.GoodsEntity;

public class GoodsBiz {
	GoodsDao dao = new GoodsDao();
	/**
	 * 查询所有商品
	 * @return
	 */
	public ArrayList<GoodsEntity> selectGoods(){
		return dao.selectGoods();
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int delete(String id) {
		return dao.delete(id);
	}
	/**
	 * 从
	 */
	public ArrayList<GoodsClassEntity> selectc(){
		return dao.selectc();
	}
	public int update(GoodsEntity d) {
		return dao.update(d);
	}
	public int liqi(GoodsEntity d) {
		return dao.liqi(d);
	}
}
