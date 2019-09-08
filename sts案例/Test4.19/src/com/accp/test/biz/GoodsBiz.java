package com.accp.test.biz;

import java.util.ArrayList;

import com.accp.test.dao.GoodsDao;
import com.accp.test.entity.Goods;
import com.accp.test.entity.GoodsClass;
import com.accp.test.entity.newG;

/**
 * 
 * <p>
 * Title: GoodsBiz
 * </p>
 * <p>
 * Description:业务逻辑层
 * </p>
 * 
 * @author Apple
 * 
 * @date 2019年4月19日
 */
public class GoodsBiz {
	GoodsDao gd = new GoodsDao();

	// 删除商品信息
	public void DelGoods(Integer did) {
		Integer check = gd.DelGoods(did);
		if (check == 0) {
			throw new RuntimeException("删除失败");
		}

	}

	// 查询所有商品信息
	public ArrayList<newG> SelAll() {
		return gd.SelAll();
	}

	// 查询所有商品类型
	public ArrayList<GoodsClass> SelGoodsClazz() {
		return gd.SelGoodsClazz();
	}

	// 添加商品信息
	public void AddGoods(Goods g1) {
		int check = gd.AddGoods(g1);
		if (check == 0) {
			throw new RuntimeException("添加失败");
		}
	}
	
	//修改商品信息
	public void UpdateGoods(Goods g1) {
		int check =gd.UpdateGoods(g1);
		if (check == 0) {
			throw new RuntimeException("修改失败");
		}
	}
}
