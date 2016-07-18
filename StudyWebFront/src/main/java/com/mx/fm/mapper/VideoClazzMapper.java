package com.mx.fm.mapper;

import com.mx.fm.model.Comment;
import com.mx.fm.model.VideoClazz;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 表:sdy_video_class  视频分类
 * Created by jack on 16/5/27.
 */
public interface VideoClazzMapper {

    @Insert("INSERT INTO sdy_video_class(name,desc) values(#{name},#{desc})")
    int addVideoClazz(VideoClazz videoClazz);

    @Select("SELECT * FROM sdy_video_class LIMIT #{0},#{1}")
    List<VideoClazz> findVideoClazzs(int page, int rows);

    @Select("SELECT * FROM sdy_video_class")
    List<VideoClazz> findAllVideoClazzs();

    @Select("SELECT * FROM sdy_video_class WHERE name =#{0}")
    VideoClazz findCommentByName(String name);

    @Select("SELECT * FROM sdy_video_class WHERE id =#{0}")
    VideoClazz findCommentByID(int id);

    @Delete("DELETE FROM sdyweb_clazz WHERE id=#{id}")
    int deleteCommentByUsername(int id);
}
