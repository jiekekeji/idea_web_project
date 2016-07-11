package com.mx.fm.model;

/**
 * Created by jack on 16/7/11.
 */
public class Comment {

    private long id;
    private String comment;
    private long timemillis;
    private String  videoid;
    private String  username;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getTimemillis() {
        return timemillis;
    }

    public void setTimemillis(long timemillis) {
        this.timemillis = timemillis;
    }

    public String getVideoid() {
        return videoid;
    }

    public void setVideoid(String videoid) {
        this.videoid = videoid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", timemillis=" + timemillis +
                ", videoid='" + videoid + '\'' +
                ", username='" + username + '\'' +
                '}';
    }



}
