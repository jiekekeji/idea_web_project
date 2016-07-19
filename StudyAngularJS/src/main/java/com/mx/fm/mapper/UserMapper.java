package com.mx.fm.mapper;

import com.mx.fm.model.User;
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

}
