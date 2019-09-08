package com.accp.dao;

import java.util.List;

import com.accp.entity.Member;

public interface IMemberDao {
	/**
	 * 
	 * @title: queryAll
	 * @description: 查询全部
	 * @return
	 */
	public List<Member> queryAll();

	/**
	 * 
	 * @title: loadByName
	 * @description: 根据name唯一加载
	 * @param name
	 * @return
	 */
	public Member loadByName(String name);
	
	/**
	 * 
	 * @title: loadByName
	 * @description: 根据name和pwd唯一加载
	 * @param name
	 * @return
	 */
	public Member loadByName(String name,String pwd);

	/**
	 * 
	 * @title: queryByName
	 * @description: 根据用户名模糊查询
	 * @param userName
	 * @return
	 */
	public List<Member> queryByName(String userName);

	/**
	 * 
	 * @title: save
	 * @description: 保存
	 * @param member
	 * @return
	 */
	public int save(Member member);

	/**
	 * 
	 * @title: update
	 * @description: 更新
	 * @param member
	 * @return
	 */
	public int update(Member member);

	/**
	 * 
	 * @title: deleteByName
	 * @description: 删除
	 * @param name
	 * @return
	 */
	public int deleteByName(String name);

}
