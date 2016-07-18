package com.mx.fm.model;

/**
 * 视频分类信息
 * Created by jack on 16/7/11.
 */
public class VideoClazz {

    private long id;
    private String name;
    private String content;
    private long totalCount;//该分类下的总数

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "VideoClazz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", totalCount=" + totalCount +
                '}';
    }
}
