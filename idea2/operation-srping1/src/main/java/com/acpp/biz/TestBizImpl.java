package com.acpp.biz;

import org.junit.Test;

import com.acpp.dao.BizDao;
import com.acpp.dao.TestDaoImpl;

public class TestBizImpl implements BizDao{
	private TestDaoImpl dao;
	
	public TestDaoImpl getDao() {
		return dao;
	}

	public void setDao(TestDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public void add() {
		dao.save();
		
	}

	@Override
	public void remove() {
		dao.delete();
	}

	public TestBizImpl() {
		super();
	}

}
