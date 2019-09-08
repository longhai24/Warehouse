package com.accp.ajax.dao;

import java.util.ArrayList;

import com.accp.ajax.entity.Staff;

/**
 * 
 * <p>
 * Title: StaffDao
 * </p>
 * <p>
 * Description:ִ�ж����ݿ����
 * </p>
 * 
 * @author Apple
 * 
 * @date 2019��4��4��
 */
public class StaffDao extends BaseDao implements IStaffDao {

	// ��ѯ���еķ���
	/* (non-Javadoc)
	 * @see com.accp.ajax.dao.IStaffDao#SelectAll()
	 */
	@Override
	public ArrayList<Staff> SelectAll() {
		String sql = "SELECT * FROM `staff`";
		ArrayList<Staff> list = new ArrayList<>();
		rs = super.Select(sql);
		try {
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String site = rs.getString("site");
				String email = rs.getString("email");
				Staff sta = new Staff(id, name, site, email);
				list.add(sta);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		} finally {
			super.Close(pst, conn);
		}
		return list;
	}

	//����id��ѯ�ķ���
	/* (non-Javadoc)
	 * @see com.accp.ajax.dao.IStaffDao#SelectSome(java.lang.Integer)
	 */
	@Override
	public Staff SelectSome(Integer id) {
		String sql = "SELECT * FROM `staff` WHERE id=?";
		Staff sta = new Staff();
		rs = super.Select(sql, id);
		try {
			while (rs.next()) {
				Integer id1 = rs.getInt("id");
				String name = rs.getString("name");
				String site = rs.getString("site");
				String email = rs.getString("email");
				sta = new Staff(id1, name, site, email);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		finally {
			super.Close(pst, conn);
		}
		return sta;
	}
}
