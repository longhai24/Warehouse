package com.accp.tow.biz;

import java.util.ArrayList;

import com.accp.tow.dao.TenderDao;
import com.accp.tow.entity.BidEntity;
import com.accp.tow.entity.TenderEntity;

public class TenderBiz {
	TenderDao dao = new TenderDao();
	//调用查询
	public ArrayList<TenderEntity> select(){
		return dao.select();
	}
	//删除
	public int delete(String id) {
		return dao.delete(id);
	}
	//详情查询
	public ArrayList<BidEntity> selectbid(String id){
		return dao.selectbid(id);
	}
}
