package com.accp.tow.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.accp.tow.entity.BidEntity;
import com.accp.tow.entity.TenderEntity;

public class TenderDao extends BaseDao{
	/**
	 * 查询招商
	 * @return
	 */
	public ArrayList<TenderEntity> select(){
		String sql =  "select * from `tender`";
		ArrayList<TenderEntity> list = new ArrayList<>();
		ResultSet re = super.query(sql);
		try {
			while(re.next()) {
				Integer tender_id = re.getInt("tender_id");
				String project_name = re.getString("project_name");
				TenderEntity t = new TenderEntity(tender_id, project_name);
				list.add(t);
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
	 * 删除投标
	 * @param id
	 * @return
	 */
	public int delete(String id) {
		String sql = "DELETE FROM `bid` WHERE `tender_id` = ?";
		int i = super.exceuteUpdate(sql,id);
		int j = deletebid(id);
		return j;
	}
	/**
	 * 删除招商
	 */
	public int deletebid(String id) {
			String mysql = "DELETE FROM `tender` WHERE `tender_id` = ?";
			int i = super.exceuteUpdate(mysql,id);
			return i;
	}
	/**
	 * 详情查询
	 */
	public ArrayList<BidEntity> selectbid(String id){
		String sql = "SELECT * FROM `bid` AS b INNER JOIN  `tender` AS t ON b.`tender_id` = t.`tender_id` WHERE t.`tender_id` = ?";
		ResultSet re = super.query(sql,id);
		ArrayList<BidEntity> list = new ArrayList<>();
		try {
			while(re.next()) {
				Integer tender_id = re.getInt("tender_id");
				String project_name = re.getString("project_name");
				TenderEntity t = new TenderEntity(tender_id, project_name);
				 Integer bid_id = re.getInt("bid_id");
				 String company = re.getString("company");
				 BidEntity bid = new BidEntity(bid_id, company,t);
				 list.add(bid);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			super.closeAll(re);
		}
		return list;
	}
}
