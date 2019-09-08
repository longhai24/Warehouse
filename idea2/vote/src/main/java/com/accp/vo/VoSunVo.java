package com.accp.vo;

public class VoSunVo {
    private String voption;
    private Integer sun;

    public String getVoption() {
        return voption;
    }

    public void setVoption(String voption) {
        this.voption = voption;
    }

    public Integer getSun() {
        return sun;
    }

    public void setSun(Integer sun) {
        this.sun = sun;
    }

    @Override
    public String toString() {
        return "VoSunVo{" +
                "voption='" + voption + '\'' +
                ", sun=" + sun +
                '}';
    }
}
