package com.accp.test.dao;

import java.util.ArrayList;

import com.accp.test.entity.Goods;
import com.accp.test.entity.GoodsClass;
import com.accp.test.entity.newG;

public interface IGoodsDao {

	//��ѯ������Ʒ��Ϣ
	ArrayList<newG> SelAll();

	//��ѯ������Ʒ����
	ArrayList<GoodsClass> SelGoodsClazz();

	//�����Ʒ��Ϣ
	int AddGoods(Goods g1);

	//�޸���Ʒ��Ϣ
	int UpdateGoods(Goods g1);

	//ɾ����Ʒ��Ϣ
	int DelGoods(Integer did);

}