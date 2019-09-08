package com.accp.biz;

import java.util.ArrayList;

import com.accp.dao.DepDao;
import com.accp.entity.DepEntity;
import com.accp.entity.DepstaEntity;

public class DepBiz {
	DepDao dao = new DepDao();
	/**
	 * 查询所有部门
	 * @return
	 */
	public ArrayList<DepEntity> selectDeps(){
		return dao.selectDeps();
	}
	
	/**
	 * 根据部门查询所有员工
	 * @return
	 */
	public ArrayList<DepstaEntity> selectSta(String did){
		return dao.selectSta(did);
	}
	/**
	 * 删除员工
	 * @param id
	 * @return
	 */
	public int delete(String id) {
		return dao.delete(id);
	}
	/**
	 * 查询当前人数
	 * @param z
	 * @return
	 */
	public String selectZ(String z) {
		return dao.selectZ(z);
	}
}
