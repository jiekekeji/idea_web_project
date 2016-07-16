package com.mx.fm.model;

/**
 * Created by Administrator on 2016-07-16.
 */
public class VideoImg {

    private Long id;
    private String imgurl;
    private Long videoid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public Long getVideoid() {
        return videoid;
    }

    public void setVideoid(Long videoid) {
        this.videoid = videoid;
    }

    @Override
    public String toString() {
        return "VideoImg{" +
                "id=" + id +
                ", imgurl='" + imgurl + '\'' +
                ", videoid=" + videoid +
                '}';
    }
}
