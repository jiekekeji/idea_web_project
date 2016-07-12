package com.mx.fm.model;

/**
 * 用户收藏的视频
 * Created by jack on 16/5/27.
 */
public class Collection {

    private long id;
    private String username;
    private String videoid;

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

    public String getVideoid() {
        return videoid;
    }

    public void setVideoid(String videoid) {
        this.videoid = videoid;
    }



    @Override
    public String toString() {
        return "Collection{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", videoid='" + videoid + '\'' +
                '}';
    }



}
