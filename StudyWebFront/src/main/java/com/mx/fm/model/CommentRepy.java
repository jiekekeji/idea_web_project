package com.mx.fm.model;

/**
 * 视频评论的回复
 * Created by Administrator on 2016-07-16.
 */
public class CommentRepy {
    private Long id;
    private String content;
    private Long time;
    private Long commentid;
    private String username;
    private String forusername;
    private Integer praise;
    private Integer week;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getCommentid() {
        return commentid;
    }

    public void setCommentid(Long commentid) {
        this.commentid = commentid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getForusername() {
        return forusername;
    }

    public void setForusername(String forusername) {
        this.forusername = forusername;
    }

    public Integer getPraise() {
        return praise;
    }

    public void setPraise(Integer praise) {
        this.praise = praise;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    @Override
    public String toString() {
        return "CommentRepy{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", commentid=" + commentid +
                ", username='" + username + '\'' +
                ", forusername='" + forusername + '\'' +
                ", praise=" + praise +
                ", week=" + week +
                '}';
    }
}
