package com.mx.fm.mapper;

import com.mx.fm.model.Comment;
import com.mx.fm.model.Video;
import com.mx.fm.model.VideoClazz;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 表:sdyweb_video
 * Created by jack on 16/5/27.
 */
public interface VideoMapper {

    @Insert("INSERT INTO sdyweb_video(title,url,imgurl,from,times,clazzid,recommend)" +
            "values(#{title},#{url},#{imgurl},#{from},#{times},#{clazzid},#{recommend})")
    int addVideo(Video video);

    @Select("SELECT * FROM sdyweb_video WHERE videoid=#{0}")
    Video findVideosByVideoID(int videoid,int page, int rows);

    @Select("SELECT * FROM sdyweb_video WHERE clazzid=#{0} LIMIT #{1},#{2} ORDER BY times DESC")
    List<Video> findVideosByClazzID(int clazzid,int page, int rows);

    @Delete("DELETE FROM sdyweb_video WHERE videoid=#{videoid}")
    int deleteVideoByUsername(int videoid);

    @Update("UPDATE sdyweb_video SET title=#{title},url=#{url},imgurl=#{imgurl}," +
            "from=#{from},times=#{times},clazzid=#{clazzid},recommend=#{recommend}," +
            "WHERE id=#{id}")
    int updateVideo(Video video);
}
