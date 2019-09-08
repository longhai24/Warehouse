package com.tx.pojo;

import java.util.Date;

/**
 * @description:
 * @author: apple
 * @date: 2019-05-30 20:27
 */
public class tttr {
    private  Integer voteid;//投票编号
    private  String votepic;//投票图片地址
    private  String votetitle;//投票标题
    private String voteparticulars;//投票介绍
    private String voteoption1;//投票选项1
    private String voteoption2;//投票选项1
    private String voteoption3;//投票选项1
    private String voteoption4;//投票选项1
    private String votedate;//创建日期
    private Integer voteoption1poll;//投票选项1票数
    private Integer voteoption2poll;//投票选项2票数
    private Integer voteoption3poll;//投票选项3票数
    private Integer voteoption4poll;//投票选项4票数
    private  Double sum;

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public tttr() {
    }

    @Override
    public String toString() {
        return "tttr{" +
                "voteid=" + voteid +
                ", votepic='" + votepic + '\'' +
                ", votetitle='" + votetitle + '\'' +
                ", voteparticulars='" + voteparticulars + '\'' +
                ", voteoption1='" + voteoption1 + '\'' +
                ", voteoption2='" + voteoption2 + '\'' +
                ", voteoption3='" + voteoption3 + '\'' +
                ", voteoption4='" + voteoption4 + '\'' +
                ", votedate='" + votedate + '\'' +
                ", voteoption1poll=" + voteoption1poll +
                ", voteoption2poll=" + voteoption2poll +
                ", voteoption3poll=" + voteoption3poll +
                ", voteoption4poll=" + voteoption4poll +
                '}';
    }

    public Integer getVoteid() {
        return voteid;
    }

    public void setVoteid(Integer voteid) {
        this.voteid = voteid;
    }

    public String getVotepic() {
        return votepic;
    }

    public void setVotepic(String votepic) {
        this.votepic = votepic;
    }

    public String getVotetitle() {
        return votetitle;
    }

    public void setVotetitle(String votetitle) {
        this.votetitle = votetitle;
    }

    public String getVoteparticulars() {
        return voteparticulars;
    }

    public void setVoteparticulars(String voteparticulars) {
        this.voteparticulars = voteparticulars;
    }

    public String getVoteoption1() {
        return voteoption1;
    }

    public void setVoteoption1(String voteoption1) {
        this.voteoption1 = voteoption1;
    }

    public String getVoteoption2() {
        return voteoption2;
    }

    public void setVoteoption2(String voteoption2) {
        this.voteoption2 = voteoption2;
    }

    public String getVoteoption3() {
        return voteoption3;
    }

    public void setVoteoption3(String voteoption3) {
        this.voteoption3 = voteoption3;
    }

    public String getVoteoption4() {
        return voteoption4;
    }

    public void setVoteoption4(String voteoption4) {
        this.voteoption4 = voteoption4;
    }

    public String getVotedate() {
        return votedate;
    }

    public void setVotedate(String votedate) {
        this.votedate = votedate;
    }

    public Integer getVoteoption1poll() {
        return voteoption1poll;
    }

    public void setVoteoption1poll(Integer voteoption1poll) {
        this.voteoption1poll = voteoption1poll;
    }

    public Integer getVoteoption2poll() {
        return voteoption2poll;
    }

    public void setVoteoption2poll(Integer voteoption2poll) {
        this.voteoption2poll = voteoption2poll;
    }

    public Integer getVoteoption3poll() {
        return voteoption3poll;
    }

    public void setVoteoption3poll(Integer voteoption3poll) {
        this.voteoption3poll = voteoption3poll;
    }

    public Integer getVoteoption4poll() {
        return voteoption4poll;
    }

    public void setVoteoption4poll(Integer voteoption4poll) {
        this.voteoption4poll = voteoption4poll;
    }
}
