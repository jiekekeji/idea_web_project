package com.mx.fm.mapper;

import com.mx.fm.model.Collection;
import com.mx.fm.model.Comment;
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

    //查找用户
    @Select("SELECT * FROM sdy_user WHERE username = #{0} LIMIT #{1},#{2}")
    List<User> findUsersByUsername(String username,int page, int rows);

    //查找用户
    @Select("SELECT * FROM sdy_user WHERE phonenum = #{0} LIMIT #{1},#{2}")
    List<User> findUserByPhonenum(String phonenum,int page, int rows);

    //查找用户列表
    @Select("SELECT * FROM sdy_user LIMIT #{0},#{1}")
    List<User> findAllUsers(int page, int rows);

    //删除用户
    @Select("DELETE FROM sdy_user WHERE username=#{username}")
    int deleteUserByUsername(String username);

    //查找用户收藏的视频
    @Select("SELECT tvid.id,tvid.title,tvid.content,tvid.source,tvid.duration,tvid.uploadtime,tvid.language," +
            "tvid.status,tvid.istop,tvid.videourl,tvid.classid FROM sdy_collection_video tcoll LEFT JOIN " +
            "sdy_video tvid ON tcoll.videoid=tvid.id WHERE tcoll.username=#{0} LIMIT #{1},#{2}")
    List<Video> findColleciontVideo(String username,int page, int rows);

    //删除收藏
    @Delete("DELETE FROM sdy_collection_video WHERE videoid=#{videoid}")
    int deleteVideoCommentByVideoid(int videoid);

    //查询用户的评论
    @Select("SELECT * FROM sdy_comment WHERE username = #{0} LIMIT #{1},#{2}")
    List<Comment> findCommentsByUsername(String username,int page,int rows);

    //用户删除评论
    @Select("DELETE FROM sdy_comment WHERE username=#{0}")
    List<Comment> deleteCommentsByUsername(String username);

    //修改密码
    @Update("UPDATE sdy_user t SET t.password=#{0} WHERE t.username=#{1} AND t.password=#{2}")
    int updatePassword(String username, String oldpassword, String newpasswrod);

    //修改 昵称,电话号,QQ号,头像,微信,邮箱,自我介绍
    @Update("UPDATE sdy_user t SET t.nickname=#{nickname},t.phonenum=#{phonenum},t.qq=#{qq}," +
            "t.headerurl=#{headerurl},t.weixin=#{weixin},t.email=#{email},t.introduce=#{introduce}" +
            "WHERE t.username=#{username}")
    int updateUser(User user);

    //修改头像
    @Update("UPDATE sdy_user t SET  t.headerurl=#{0} WHERE t.username=#{1}")
    int updateUserHeaderurl(String username,String headerurl);

    //修改头像
    @Update("UPDATE sdy_user t SET  t.introduce=#{0} WHERE t.username=#{1}")
    int updateUserIntroduce(String username,String introduce);



}
