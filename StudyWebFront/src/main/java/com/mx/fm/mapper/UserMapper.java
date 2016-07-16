package com.mx.fm.mapper;

import com.mx.fm.model.Collection;
import com.mx.fm.model.User;
import com.mx.fm.model.Video;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 表:sdy_user 用户表
 * 表：sdy_collection_video 用户收藏
 * Created by jack on 16/5/27.
 */
public interface UserMapper {

    //添加用户
    @Insert("INSERT INTO sdy_user(username,nickname,password,phonenum,qq,headerurl,registertime,weixin,roleid,email,introduce) " +
            "VALUES(#{username},#{nickname},#{password},#{phonenum},#{qq},#{headerurl},#{registertime},#{weixin},#{roleid},#{email},#{introduce})")
    int addUser(User user);

    //添加收藏
    @Insert("INSERT INTO sdy_collection_video(time,nickname,videoid,username VALUES(#{time},#{nickname},#{videoid},#{username})")
    int addCollection(Collection collection);

    //查找用户
    @Select("SELECT * FROM sdy_user WHERE username = #{username}")
    User findUserByUsername(String username);

    //查找用户收藏的视频
    @Select("SELECT tvid.id,tvid.title,tvid.content,tvid.source,tvid.duration,tvid.uploadtime,tvid.language," +
            "tvid.status,tvid.istop,tvid.videourl,tvid.classid FROM sdy_collection_video tcoll LEFT JOIN " +
            "sdy_video tvid ON tcoll.videoid=tvid.id WHERE tcoll.username=#{0} LIMIT #{1},#{2}")
    List<Video> findColleciontVideo(String username,int page, int rows);

    //删除收藏
    @Delete("DELETE FROM sdy_comment WHERE videoid=#{videoid}")
    int deleteVideoCommentByVideoid(int videoid);

    @Update("UPDATE sdyweb_user t SET t.password=#{0} WHERE t.username=#{1} AND t.password=#{2}")
    int updatePassword(String username, String oldpassword, String newpasswrod);
}
