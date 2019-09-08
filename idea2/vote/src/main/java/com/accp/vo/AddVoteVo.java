package com.accp.vo;

import java.util.List;

public class AddVoteVo {
    private  String name;
    private String vpid;
    private String voptionA; //选项1
    private String voptionB;//选项2
    private String voptionC;//选项3
    private String voptionD;//选项4
    private String voptionE;//选项5

    @Override
    public String toString() {
        return "AddVoteVo{" +
                "name='" + name + '\'' +
                ", vpid='" + vpid + '\'' +
                ", voptionA='" + voptionA + '\'' +
                ", voptionB='" + voptionB + '\'' +
                ", voptionC='" + voptionC + '\'' +
                ", voptionD='" + voptionD + '\'' +
                ", voptionE='" + voptionE + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVpid() {
        return vpid;
    }

    public void setVpid(String vpid) {
        this.vpid = vpid;
    }

    public String getVoptionA() {
        return voptionA;
    }

    public void setVoptionA(String voptionA) {
        this.voptionA = voptionA;
    }

    public String getVoptionB() {
        return voptionB;
    }

    public void setVoptionB(String voptionB) {
        this.voptionB = voptionB;
    }

    public String getVoptionC() {
        return voptionC;
    }

    public void setVoptionC(String voptionC) {
        this.voptionC = voptionC;
    }

    public String getVoptionD() {
        return voptionD;
    }

    public void setVoptionD(String voptionD) {
        this.voptionD = voptionD;
    }

    public String getVoptionE() {
        return voptionE;
    }

    public void setVoptionE(String voptionE) {
        this.voptionE = voptionE;
    }

    public AddVoteVo() {
    }
}
