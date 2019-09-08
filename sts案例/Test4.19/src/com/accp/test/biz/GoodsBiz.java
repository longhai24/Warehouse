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
 * Description:ҵ���߼���
 * </p>
 * 
 * @author Apple
 * 
 * @date 2019��4��19��
 */
public class GoodsBiz {
	GoodsDao gd = new GoodsDao();

	// ɾ����Ʒ��Ϣ
	public void DelGoods(Integer did) {
		Integer check = gd.DelGoods(did);
		if (check == 0) {
			throw new RuntimeException("ɾ��ʧ��");
		}

	}

	// ��ѯ������Ʒ��Ϣ
	public ArrayList<newG> SelAll() {
		return gd.SelAll();
	}

	// ��ѯ������Ʒ����
	public ArrayList<GoodsClass> SelGoodsClazz() {
		return gd.SelGoodsClazz();
	}

	// �����Ʒ��Ϣ
	public void AddGoods(Goods g1) {
		int check = gd.AddGoods(g1);
		if (check == 0) {
			throw new RuntimeException("���ʧ��");
		}
	}
	
	//�޸���Ʒ��Ϣ
	public void UpdateGoods(Goods g1) {
		int check =gd.UpdateGoods(g1);
		if (check == 0) {
			throw new RuntimeException("�޸�ʧ��");
		}
	}
}
