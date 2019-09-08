package com.accp.test.dao;

import java.util.ArrayList;

import com.accp.test.entity.Goods;
import com.accp.test.entity.GoodsClass;
import com.accp.test.entity.newG;

public interface IGoodsDao {

	//查询所有商品信息
	ArrayList<newG> SelAll();

	//查询所有商品类型
	ArrayList<GoodsClass> SelGoodsClazz();

	//添加商品信息
	int AddGoods(Goods g1);

	//修改商品信息
	int UpdateGoods(Goods g1);

	//删除商品信息
	int DelGoods(Integer did);

}