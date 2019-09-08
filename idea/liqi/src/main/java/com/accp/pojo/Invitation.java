package com.accp.pojo;


import javax.xml.crypto.Data;

public class Invitation {
    private Integer id;//帖子编号
    private String title;//帖子标题
    private String summary;//帖子摘要
    private String author;//作者
    private String createdate;//创建时间

    @Override
    public String toString() {
        return "Invitation{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", author='" + author + '\'' +
                ", createdate=" + createdate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public Invitation() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }
}
