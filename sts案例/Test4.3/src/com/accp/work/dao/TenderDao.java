package com.accp.work.dao;

import java.util.ArrayList;

import com.accp.work.entity.Bid;
import com.accp.work.entity.Tender;

public class TenderDao extends BaseDao implements  ItenderDao2 {
	
	//获取所有投标信息
	/* (non-Javadoc)
	 * @see com.accp.work.dao.ItenderDao2#getAll()
	 */
	@Override
	public ArrayList<Tender> getAll(){
		ArrayList<Tender> list = new ArrayList<>();
		String sql = "select * from tender";
		rs = super.Select(sql);
		try {
			while (rs.next()) {
				Integer tender_id = rs.getInt("tender_id");
				String project_name = rs.getString("project_name");
				Tender ten = new Tender(project_name, tender_id);
				list.add(ten);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		finally {
			super.Close(pst, conn);
		}
		return list;
	}

	//获得指定的招标信息
	/* (non-Javadoc)
	 * @see com.accp.work.dao.ItenderDao2#get(java.lang.String)
	 */
	@Override
	public Tender get(int i) {
		String sql = "SELECT   b.`company` AS bcom,  t.`tender_id` AS tid,  t.`project_name` AS tname,  b.`bid_id` AS bid,  b.`tender_id` AS btid FROM  `bid` AS b  JOIN `tender` AS t ON b.`tender_id` = t.`tender_id`  WHERE t.`tender_id` = ? ";
		rs = super.Select(sql, i);
		ArrayList<Bid> blist = new ArrayList<>();
		String tname = "";
		Integer tid = null;
		Tender t1 = new Tender();
		try {
			while (rs.next()) {
				 tname = rs.getString("tname");
				String bcom = rs.getString("bcom");
				 tid = rs.getInt("tid");
				Integer bid = rs.getInt("bid");
				Bid bi = new Bid(bid, bcom);
				blist.add(bi);
			}
			t1 = new Tender(tname, tid, blist);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		finally {
			super.Close(pst, conn);
		}
		return t1;
	}

	//删除指定的招标信息
	/* (non-Javadoc)
	 * @see com.accp.work.dao.ItenderDao2#delete(java.lang.String)
	 */
	@Override
	public int delete(String tenderId) {
		Integer id = Integer.valueOf(tenderId);
		Integer o = null;
		String sql = "DELETE FROM `bid` WHERE `tender_id`=?";
		if (super.Update(sql, id)>0) {
			sql = "DELETE FROM `tender` WHERE `tender_id`=?";
			 o =super.Update(sql, id);
		}
		return o;
	}
}
