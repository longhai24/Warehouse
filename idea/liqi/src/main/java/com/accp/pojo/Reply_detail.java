package com.accp.pojo;

import javax.xml.crypto.Data;

public class Reply_detail {
    private Integer id;//编号
    private Integer invid;//帖子编号
    private String content;//回复内容
    private String author;//回复人昵称
    private Data createdate;//回复时间

    @Override
    public String toString() {
        return "Reply_detail{" +
                "id=" + id +
                ", invid=" + invid +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", createdate=" + createdate +
                '}';
    }

    public Reply_detail() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInvid() {
        return invid;
    }

    public void setInvid(Integer invid) {
        this.invid = invid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Data getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Data createdate) {
        this.createdate = createdate;
    }
}
