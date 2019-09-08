package com.tx.pojo;

/**
 * @description:用户实体类
 * @author: apple
 * @date: 2019-05-28 20:48
 */
public class User {
    private Integer userid;//用户编号
    private String userName;//用户姓名
    private String userPwd;//用户密码

    public User() {
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}
