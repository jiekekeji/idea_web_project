package com.mx.fm.model;

/**
 * 视频信息
 * Created by jack on 16/7/11.
 */
public class Video {

    private long id;
    private String title;
    private String content;
    private String source;
    private long duration;//视频时长

    private long uploadtime;//上传时间
    private String language;//语言
    private int status;

    private long istop;//是否是推荐视频
    private String videourl;//播放地址
    private int classid;//视频分类
    private String outlineImgUrl;//封面图

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(long uploadtime) {
        this.uploadtime = uploadtime;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getIstop() {
        return istop;
    }

    public void setIstop(long istop) {
        this.istop = istop;
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public String getOutlineImgUrl() {
        return outlineImgUrl;
    }

    public void setOutlineImgUrl(String outlineImgUrl) {
        this.outlineImgUrl = outlineImgUrl;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", source='" + source + '\'' +
                ", duration=" + duration +
                ", uploadtime=" + uploadtime +
                ", language='" + language + '\'' +
                ", status=" + status +
                ", istop=" + istop +
                ", videourl='" + videourl + '\'' +
                ", classid=" + classid +
                ", outlineImgUrl='" + outlineImgUrl + '\'' +
                '}';
    }
}
