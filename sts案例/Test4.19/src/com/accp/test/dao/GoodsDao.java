package com.accp.test.dao;

import java.util.ArrayList;

import com.accp.test.entity.Goods;
import com.accp.test.entity.GoodsClass;
import com.accp.test.entity.newG;

/**
 * 
* <p>Title: GoodsDao</p>  
* <p>Description:���ݿ������ </p>  
* @author Apple 

* @date 2019��4��19��
 */
public class GoodsDao extends BaseDao implements IGoodsDao {

	//��ѯ������Ʒ��Ϣ
	/* (non-Javadoc)
	 * @see com.accp.test.dao.IGoodsDao#SelAll()
	 */
	@Override
	public ArrayList<newG> SelAll(){
		String sql = "SELECT g.`goodsid` AS gid ,g.`goodsname` AS gname,g.`goodsprice` AS gprice,g.`goodstype` AS gtype , c.`goodsclassname` AS cname FROM `goods` AS g JOIN `goodsclass` AS c ON g.`goodsclassid` = c.`goodsclassid`";
		ArrayList<newG> list = new ArrayList<>();
		rs = super.Select(sql);
		try {
			while (rs.next()) {
				newG n1 = new newG();
				n1.setGoodsClassName(rs.getString("cname"));
				n1.setGoodsId(rs.getInt("gid"));
				n1.setGoodsPrice(rs.getFloat("gprice"));
				n1.setGoodsType(rs.getString("gtype"));
				n1.setGoodsName(rs.getString("gname"));
				list.add(n1);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			super.Close(pst, conn);
		}
		return list;
	}

	//��ѯ������Ʒ����
	/* (non-Javadoc)
	 * @see com.accp.test.dao.IGoodsDao#SelGoodsClazz()
	 */
	@Override
	public ArrayList<GoodsClass> SelGoodsClazz(){
		String sql = "SELECT * FROM `goodsclass`";
		ArrayList<GoodsClass> list = new ArrayList<>();
		rs = super.Select(sql);
		try {
			while (rs.next()) {
				GoodsClass n1 = new GoodsClass();
				n1.setGoodsClassId(rs.getInt("goodsclassid"));
				n1.setGoodsClassName(rs.getString("goodsclassname"));
				list.add(n1);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			super.Close(pst, conn);
		}
		return list;
	}

	//�����Ʒ��Ϣ
	/* (non-Javadoc)
	 * @see com.accp.test.dao.IGoodsDao#AddGoods(com.accp.test.entity.Goods)
	 */
	@Override
	public int AddGoods(Goods g1) {
		String sql = "INSERT INTO `goods`(`goodsname`,`goodstype`,`goodsclassid`,`goodsprice`) VALUES(?,?,?,?)";
		return super.Update(sql, g1.getGoodsName(),g1.getGoodsType(),g1.getGoodsClassId(),g1.getGoodsPrice());
	}
	
	//�޸���Ʒ��Ϣ
	/* (non-Javadoc)
	 * @see com.accp.test.dao.IGoodsDao#UpdateGoods(com.accp.test.entity.Goods)
	 */
	@Override
	public int UpdateGoods(Goods g1) {
		String sql = "UPDATE `goods` SET `goodsname`=?,`goodstype`=?,`goodsclassid`=?,`goodsprice`=? WHERE `goodsid` =?";
		return super.Update(sql, g1.getGoodsName(),g1.getGoodsType(),g1.getGoodsClassId(),g1.getGoodsPrice(),g1.getGoodsId());
	}
	
	//ɾ����Ʒ��Ϣ
	/* (non-Javadoc)
	 * @see com.accp.test.dao.IGoodsDao#DelGoods(java.lang.Integer)
	 */
	@Override
	public int DelGoods(Integer did) {
		String sql = "DELETE FROM `goods` WHERE `goodsid` =?";
		return super.Update(sql, did);
	}
}
