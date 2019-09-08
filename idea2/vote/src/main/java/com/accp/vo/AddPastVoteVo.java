package com.accp.vo;

public class AddPastVoteVo {
    private String uid; //用户id
    private String vid; //问题编号
    private String voption;//问题选项

    @Override
    public String toString() {
        return "AddPastVoteVo{" +
                "uid='" + uid + '\'' +
                ", vid='" + vid + '\'' +
                ", voption='" + voption + '\'' +
                '}';
    }

    public AddPastVoteVo(String uid, String vid, String voption) {
        this.uid = uid;
        this.vid = vid;
        this.voption = voption;
    }

    public AddPastVoteVo() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getVoption() {
        return voption;
    }

    public void setVoption(String voption) {
        this.voption = voption;
    }
}
