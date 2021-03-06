package com.mx.fm.model;

/**
 * 视频评论
 * Created by jack on 16/7/11.
 */
public class Comment {

    private long id;
    private String username;//评论的用户名
    private long time;//评论时间
    private String content;//评论的内容
    private long videoid;//视频ID
    private Integer praise;//赞的个数
    private Integer weak;//踩的个数

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getVideoid() {
        return videoid;
    }

    public void setVideoid(long videoid) {
        this.videoid = videoid;
    }

    public Integer getPraise() {
        return praise;
    }

    public void setPraise(Integer praise) {
        this.praise = praise;
    }

    public Integer getWeak() {
        return weak;
    }

    public void setWeak(Integer weak) {
        this.weak = weak;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", time=" + time +
                ", content='" + content + '\'' +
                ", videoid=" + videoid +
                ", praise=" + praise +
                ", weak=" + weak +
                '}';
    }
}
