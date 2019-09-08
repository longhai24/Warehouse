package com.accp.work.biz;

import java.util.ArrayList;

import com.accp.work.dao.TenderDao;
import com.accp.work.entity.Tender;

/**
 * 
* <p>Title: TenderBiz</p>  
* <p>Description: 业务逻辑操作类 </p>  
* @author Apple 

* @date 2019年4月3日
 */
public class TenderBiz {
	 TenderDao td = new TenderDao();
		 public ArrayList<Tender> getAll() {
				 return td.getAll();
	 }
		 public Tender get(int i) {
				 return td.get(i);
	}
		 public int delete(String tenderId) {
			 return td.delete(tenderId);
		 }
}
