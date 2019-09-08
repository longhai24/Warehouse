package com.accp.dao;

import com.accp.pojo.Group;
import com.accp.pojo.Vote;
import com.accp.pojo.VotePail;
import com.accp.vo.*;
import org.apache.ibatis.annotations.Param;

import com.accp.pojo.user;

import java.util.List;

public interface UserIDao {
    public user login(@Param("name") String name,@Param("pwd") String pwd);//登陆
    public int adduser(@Param("u")UserVo vo);//注册
    public Group findGroup(@Param("gid") String gid); //查询组织
    public int modifyUser(@Param("u") ModifyUserVo u); //修改用户资料
    public int addVotep(@Param("vp") VotePail vo); //添加桶
    public List<VotePail> findVp(@Param("uid") Integer uid); //查用户所有桶
    public List<VotePail> findVps(@Param("uid") Integer uid); //查用户所有桶
    public int addVote(@Param("v")AddVoteVo vo); //添加投票
    public VotePail findVotePail(@Param("vpid") String vpid); //根据桶id查询桶
    public int modifyVp(@Param("v") VotePail vp);//根据桶id修改桶
    public List<Vote> findVotes(@Param("vpid") String vpid); //根据桶id查询该桶下的所有投票
    public Vote findVote(@Param("vid") String vid); //根据vid查询他的对象
    public int modifyVote(@Param("v") Vote vo);//根据vid 修改投票
    public List<FindTermVpsVo> findTermVps(@Param("name") String name, @Param("term") String Term, @Param("gid") Integer gid);//根据条件搜索桶
    public String findTermVpSun(@Param("name") String name, @Param("term") String Term, @Param("gid") Integer gid);//根据条件搜索桶查询条数
    public VotePail findnterVote(@Param("vpid") String vpid); //根据桶id渲染投票index.html
    public int addsubmitVote(@Param("pvlist")List<AddPastVoteVo> list);
    public Integer findjinsun(@Param("vid") String vid);
    public List<VoSunVo> findjinjin(@Param("vid") String vid);
}
