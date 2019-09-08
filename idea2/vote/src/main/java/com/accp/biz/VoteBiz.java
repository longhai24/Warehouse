package com.accp.biz;

import com.accp.pojo.Group;
import com.accp.pojo.Vote;
import com.accp.pojo.VotePail;
import com.accp.vo.*;
import org.aspectj.internal.lang.annotation.ajcDeclareParents;
import org.springframework.beans.factory.annotation.Autowired;

import com.accp.dao.UserIDao;
import com.accp.pojo.user;

import java.util.List;

public class VoteBiz {
	@Autowired
	private UserIDao dao;

	/**
	 * 登陆注册
	 * @param name
	 * @param pwd
	 * @return
	 */
	public user login(String name,String pwd){
		return dao.login(name, pwd);
	}

	/**
	 * 注册
	 * @return
	 */
	public int adduser (UserVo uvo){
		return  dao.adduser(uvo);
	}

	/**
	 * 查询组织
	 * @return
	 */
	public Group findGroup(String gid) {
		return dao.findGroup(gid);
	}

	/**
	 * 修改用户资料
	 * @param u
	 * @return
	 */
	public int modifyUser(ModifyUserVo u){
		return  dao.modifyUser(u);
	}

	/**新建投票桶
	 * @return
	 */
	public  int addVotep(VotePail vp){
		return dao.addVotep(vp);
	}
	//查询用户所在的桶
	public List<VotePail> findVp(Integer uid){
		return dao.findVp(uid);
	}
	public List<VotePail> findVps(Integer uid){
		return dao.findVps(uid);
	}
	//添加投票
	public int addVote(AddVoteVo vote){
		return dao.addVote(vote);
	}

	/**
	 * 根据vpid 查询桶
	 * @param vpid
	 * @return
	 */
	public VotePail findVotePail(String vpid){
		return dao.findVotePail(vpid);
	}

	/**
	 * 修改桶
	 * @param vp
	 * @param
	 * @return
	 */
	public int modifyVp(VotePail vp){
		return dao.modifyVp(vp);
	}

	/**
	 * 根据桶ID查询该桶下的所有投票
	 * @param vpid
	 * @return
	 */
	public List<Vote> findVotes(String vpid){
		return dao.findVotes(vpid);
	}

	/**
	 * 根据vid查询他的对象
	 * @param vid
	 * @return
	 */
	public  Vote findVote(String vid){
		return dao.findVote(vid);
	}

	/**
	 * 根据vid 修改对象
	 * @return
	 */
	public int modifyVote(Vote vote){
		return dao.modifyVote(vote);
	}
	/**
	 *条件搜索桶
	 */
	public List<FindTermVpsVo> findTermVps(String name,String term,Integer gid){
		return dao.findTermVps(name,term,gid);
	}

	/**
	 * 搜索返回行数
	 * @param name
	 * @param term
	 * @param gid
	 * @return
	 */
	public String findTermVpSun(String name,String term,Integer gid){
		return dao.findTermVpSun(name,term,gid);
	}

	/**
	 * 根据桶id渲染投票index.html
	 * @param vpid
	 * @return
	 */
	public VotePail findnterVote(String vpid){
		return dao.findnterVote(vpid);
	}

	/**
	 * 添加投票
	 * @param pvlist
	 * @return
	 */
	public int addsubmitVote(List<AddPastVoteVo> pvlist){
		return dao.addsubmitVote(pvlist);
	}
	public Integer findjinsun(String vid){
		return dao.findjinsun(vid);
	}
	public List<VoSunVo> findjinjin(String vid){
		return dao.findjinjin(vid);
	}
}
