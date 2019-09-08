package com.accp.ajax.dao;

import java.util.ArrayList;

import com.accp.ajax.entity.Department;
import com.accp.ajax.entity.Staff;
import com.sun.org.apache.regexp.internal.RE;

/**
 * 
* <p>Title: TestDao</p>  
* <p>Description:数据库访问层 </p>  
* @author Apple 

* @date 2019年4月9日
 */
public class TestDao extends BaseDao implements ITestDao {
	
	//查询所有部门
	/* (non-Javadoc)
	 * @see com.accp.ajax.dao.ITestDao#SelectDem()
	 */
	@Override
	public ArrayList<Department> SelectDem(){
		String sql = "SELECT * FROM `department`";
		rs = super.Select(sql);
		ArrayList<Department> demList = new ArrayList<>();
		try {
			while (rs.next()) {
				Integer demId = rs.getInt("id");
				String demName = rs.getString("name");
				Department dem  =new Department(demId, demName);
				demList.add(dem);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		finally {
			super.Close(pst, conn);
		}
		return demList;
	} 

	//根据部门编号查找部门职员
	/* (non-Javadoc)
	 * @see com.accp.ajax.dao.ITestDao#SelectSta(java.lang.Integer)
	 */
	@Override
	public ArrayList<Staff> SelectSta(Integer did){
		String sql = "SELECT * FROM `staff`WHERE `did` = ?";
		ArrayList<Staff> StaList = new ArrayList<>();
		rs = super.Select(sql, did);
		try {
			while (rs.next()) {
				Integer staId = rs.getInt("sid");
				String staName = rs.getString("sname");
				String staAddress = rs.getString("saddress");
				String staEmail  = rs.getString("semail");
				Integer staDid = rs.getInt("did");
				Staff sta = new Staff(staId, staName, staAddress, staEmail, staDid);
				StaList.add(sta);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		finally {
			super.Close(pst, conn);
		}
		return StaList;
	}

}
