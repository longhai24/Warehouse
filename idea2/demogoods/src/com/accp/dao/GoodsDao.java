package com.accp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.accp.entity.GoodsClassEntity;
import com.accp.entity.GoodsEntity;

public class GoodsDao extends BaseDao{
	/**
	 * 查询所有商品
	 * @return
	 */
	public ArrayList<GoodsEntity> selectGoods(){
		String sql = "SELECT * FROM `goods`";
		ResultSet re = super.query(sql);
		ArrayList<GoodsEntity> list = new ArrayList<GoodsEntity>();
		try {
			while(re.next()) {
				 Integer goodsid = re.getInt("goods");
				 String goodsName = re.getString("goodsName");
				 String goodsType = re.getString("goodsType");
				 int goodsClassId = re.getInt("goodsClassId");
				 GoodsClassEntity glzz  = selectGlzz(goodsClassId);
				 float goodsPrice = re.getFloat("goodsPrice");
				 GoodsEntity g = new GoodsEntity(goodsid, goodsName, goodsType, glzz, goodsPrice);
				 list.add(g);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			super.closeAll(re);
		}
		return list;
	}
	/**
	 * 查询分类
	 * @param clzzid
	 * @return
	 */
	public GoodsClassEntity selectGlzz(int clzzid) {
		String sql = "SELECT *  FROM `goodsclass` WHERE `goodsClassId` = ?";
		ResultSet re = super.query(sql,clzzid);
		GoodsClassEntity c = new GoodsClassEntity();
		try {
			re.next();
			 int goodsClassId = re.getInt("goodsClassId");
			 String goodsClassName = re.getString("goodsClassName");
			 c = new GoodsClassEntity(goodsClassId, goodsClassName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int delete(String id) {
		String sql ="delete from goods where goods = ?";
		return super.exceuteUpdate(sql,id);
	}
	/**
	 * 从
	 */
	public ArrayList<GoodsClassEntity> selectc(){
		String sql = "SELECT * FROM `goodsclass`";
		ResultSet re = super.query(sql);
		ArrayList<GoodsClassEntity> list = new ArrayList<GoodsClassEntity>();
		try {
			while(re.next()) {
				 int goodsClassId = re.getInt("goodsClassId");
				 String goodsClassName = re.getString("goodsClassName");
				 GoodsClassEntity c = new GoodsClassEntity(goodsClassId, goodsClassName);
				 list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			super.closeAll(re);
		}
		return list;
	}
	public int update(GoodsEntity d) {
		String sql ="UPDATE `goods` SET `goodsName` = ?,`goodsType`=?,`goodsClassId`=?,`goodsPrice`=? WHERE `goods` = ?";
		int i = super.exceuteUpdate(sql,d.getGoodsName(),d.getGoodsType(),d.getGoodsclazzid(),d.getGoodsPrice(),d.getGoodsid());
		return i;
	}
	public int liqi(GoodsEntity d) {
		String sql ="INSERT INTO `goods` (`goodsName`,`goodsType`,`goodsClassId`,`goodsPrice`)VALUES(?,?,?,?)";
		int i = super.exceuteUpdate(sql,d.getGoodsName(),d.getGoodsType(),d.getGoodsclazzid(),d.getGoodsPrice());
		return i;
	}
	
}
