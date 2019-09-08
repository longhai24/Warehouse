package com.accp.vo;

public class ModifyUserVo {
    private Integer uid; //id
    private String uname; //用户名
    private String upwd;//密码
    private String uimg;//头像
    private String uEmail;//邮箱
    private String uDescri;//介绍
    private String uAddress;//地址
    private Integer gid;

    @Override
    public String toString() {
        return "ModifyUserVo{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", uimg='" + uimg + '\'' +
                ", uEmail='" + uEmail + '\'' +
                ", uDescri='" + uDescri + '\'' +
                ", uAddress='" + uAddress + '\'' +
                ", gid=" + gid +
                '}';
    }

    public ModifyUserVo() {
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUimg() {
        return uimg;
    }

    public void setUimg(String uimg) {
        this.uimg = uimg;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuDescri() {
        return uDescri;
    }

    public void setuDescri(String uDescri) {
        this.uDescri = uDescri;
    }

    public String getuAddress() {
        return uAddress;
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }
}
