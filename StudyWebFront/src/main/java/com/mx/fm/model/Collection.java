package com.mx.fm.model;

/**
 * 用户收藏的视频
 * Created by jack on 16/5/27.
 */
public class Collection {

    private long id;
    private Long time;//收藏的时间
    private String username;
    private Long videoid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getVideoid() {
        return videoid;
    }

    public void setVideoid(Long videoid) {
        this.videoid = videoid;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "id=" + id +
                ", time=" + time +
                ", username='" + username + '\'' +
                ", videoid=" + videoid +
                '}';
    }
}
