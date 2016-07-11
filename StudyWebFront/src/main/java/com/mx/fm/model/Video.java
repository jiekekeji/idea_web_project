package com.mx.fm.model;

/**
 * Created by jack on 16/7/11.
 */
public class Video {

    private long id;
    private String title;
    private String url;
    private String  imgurl;
    private String  from;

    private long times;
    private long  clazzid;
    private int  recommend;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public long getTimes() {
        return times;
    }

    public void setTimes(long times) {
        this.times = times;
    }

    public long getClazzid() {
        return clazzid;
    }

    public void setClazzid(long clazzid) {
        this.clazzid = clazzid;
    }

    public int getRecommend() {
        return recommend;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", from='" + from + '\'' +
                ", times=" + times +
                ", clazzid=" + clazzid +
                ", recommend=" + recommend +
                '}';
    }

}
