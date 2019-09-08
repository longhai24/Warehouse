package com.accp.biz;

import java.util.ArrayList;

import com.accp.dao.GoodsDao;
import com.accp.entity.GoodsClassEntity;
import com.accp.entity.GoodsEntity;

public class GoodsBiz {
	GoodsDao dao = new GoodsDao();
	/**
	 * ��ѯ������Ʒ
	 * @return
	 */
	public ArrayList<GoodsEntity> selectGoods(){
		return dao.selectGoods();
	}
	/**
	 * ɾ��
	 * @param id
	 * @return
	 */
	public int delete(String id) {
		return dao.delete(id);
	}
	/**
	 * ��
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
