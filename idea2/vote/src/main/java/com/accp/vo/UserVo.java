package com.accp.vo;

public class UserVo {
    private String name;
    private String pwd;
    private  String emial;
    private String gid;
    

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmial() {
        return emial;
    }

    public void setEmial(String emial) {
        this.emial = emial;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public UserVo(String name, String pwd, String emial, String gid) {
        this.name = name;
        this.pwd = pwd;
        this.emial = emial;
        this.gid = gid;
    }

    public UserVo() {
    }

	@Override
	public String toString() {
		return "UserVo [name=" + name + ", pwd=" + pwd + ", emial=" + emial + ", gid=" + gid + "]";
	}
    
}
