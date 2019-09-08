package com.accp.biz;

import java.util.ArrayList;

import com.accp.dao.DepDao;
import com.accp.entity.DepEntity;
import com.accp.entity.DepstaEntity;

public class DepBiz {
	DepDao dao = new DepDao();
	/**
	 * ��ѯ���в���
	 * @return
	 */
	public ArrayList<DepEntity> selectDeps(){
		return dao.selectDeps();
	}
	
	/**
	 * ���ݲ��Ų�ѯ����Ա��
	 * @return
	 */
	public ArrayList<DepstaEntity> selectSta(String did){
		return dao.selectSta(did);
	}
	/**
	 * ɾ��Ա��
	 * @param id
	 * @return
	 */
	public int delete(String id) {
		return dao.delete(id);
	}
	/**
	 * ��ѯ��ǰ����
	 * @param z
	 * @return
	 */
	public String selectZ(String z) {
		return dao.selectZ(z);
	}
}
