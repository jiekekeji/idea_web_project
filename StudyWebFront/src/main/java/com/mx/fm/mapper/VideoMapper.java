package com.mx.fm.mapper;

import com.mx.fm.model.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 表:sdy_video 视频表
 * 表:sdy_video_img_url 视频图片表
 * 表：sdy_comment  视频评论
 * Created by jack on 16/5/27.
 */
public interface VideoMapper {

    //添加视频
    @Insert("INSERT INTO sdy_video(title,content,source,duration,uploadtime,language,status,videourl,classid,istop,outlineImgUrl)" +
            "values(#{title},#{content},#{source},#{duration},#{uploadtime},#{language},#{status},#{videourl},#{classid},#{istop},#{outlineImgUrl})")
    int addVideo(Video video);

    //添加视频图片
    @Insert("INSERT INTO sdy_video_img_url(imgurl,videoid) values(#{imgurl},#{videoid})")
    int addVideoImg(VideoImg img);

    //添加视频评论
    @Insert("INSERT INTO sdy_comment(time,username,content,videoid) values(#{time},#{username},#{content},#{videoid})")
    int addVideoComment(Comment img);

    //删除视频
    @Delete("DELETE FROM sdy_video WHERE id=#{videoid}")
    int deleteVideoByVideoid(long videoid);

    //删除视频图片
    @Delete("DELETE FROM sdy_video_img_url WHERE videoid=#{videoid}")
    int deleteVideoImgByVideoid(int videoid);

    //删除视频评论
    @Delete("DELETE FROM sdy_comment WHERE videoid=#{videoid}")
    int deleteVideoCommentByVideoid(int videoid);

    //查找分页视频
    @Select("SELECT * FROM sdy_video LIMIT #{0},#{1}")
    List<Video> findVideos(int page, int rows);

    //查找推荐置顶视频
    @Select("SELECT * FROM sdy_video WHERE istop=1 LIMIT #{0},#{1}")
    List<Video> findVideosByIsTop(int page, int rows);

    //查找审核中的视频
    @Select("SELECT * FROM sdy_video WHERE status=1 LIMIT #{0},#{1}")
    List<Video> findVideosByStatus(int page, int rows);

    //查找分类下的分页视频
    @Select("SELECT * FROM sdy_video WHERE classid=#{0} LIMIT #{1},#{2} ORDER BY id DESC")
    List<Video> findVideosByClassID(int classid, int page, int rows);

    //根据ID查询视频详情
    @Select("SELECT * FROM sdy_video WHERE id=#{0}")
    Video findVideosByID(long id);

    //根据视频ID查找对应的图片
    @Select("SELECT * FROM sdy_video_img_url WHERE videoid=#{0} LIMIT #{1},#{2}")
    List<VideoImg> findVideoImgByVideoID(int videoid, int page, int rows);

    //根据视频ID查找对应的视频评论
    @Select("SELECT t1.id,t1.time,t1.username,t1.content,t1.videoid,t1.praise,t1.weak,t2.nickname,t2.headerurl " +
            "FROM sdy_comment t1 RIGHT JOIN sdy_user t2 ON t1.username=t2.username WHERE videoid=#{0} LIMIT #{1},#{2}")
    List<CommentUser> findVideoCommentByVideoID(int videoid, int page, int rows);

    //查询视频分类信息及该分类下的视频总数
    @Select("SELECT clz.id,clz.`name`,clz.content,COUNT(video.id) AS totalCount FROM sdy_video video " +
            "LEFT JOIN sdy_video_class clz ON video.classid=clz.id GROUP BY clz.id LIMIT #{0},#{1}")
    List<VideoClazz> findVideoClazz(int page, int rows);

    //根据分类名称查询视频分类信息及该分类下的视频总数
    @Select("SELECT clz.id,clz.`name`,clz.content,COUNT(video.id) AS totalCount FROM sdy_video video LEFT JOIN sdy_video_class clz ON video.classid=clz.id WHERE clz.`name`=#{0} GROUP BY clz.id LIMIT #{1},#{2}")
    List<VideoClazz> findVideoClazzByName(String name, int page, int rows);

    @Update("UPDATE sdy_video t SET t.uploadtime=#{uploadtime},t.title=#{title},t.content=#{content}," +
            "t.source=#{source},t.duration=#{duration},t.language=#{language},t.videourl=#{videourl}," +
            "t.outlineImgUrl=#{outlineImgUrl},t.classid=#{classid},t.status=#{status},t.istop=#{istop}" +
            " WHERE t.id=#{id}")
    int updateVideoByID(Video video);

    @Update("UPDATE sdy_video t SET t.outlineImgUrl=#{1} WHERE t.id=#{0}")
    int updateImgByID(long id,String outlineImgUrl);


}
