package com.mx.fm.mapper;

import com.mx.fm.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 表:sdy_user   管理员的操作
 * Created by jack on 16/5/27.
 */
public interface AdminUserMapper {

    @Insert("INSERT INTO sdy_user(username,nickname,password,phonenum,qq,headerurl,registertime,weixin,roleid,email,introduce)" +
            "values(#{username},#{nickname},#{password},#{phonenum},#{qq},#{headerurl},#{registertime},#{weixin},#{roleid},#{email},#{introduce})")
    int addUser(User user);

    @Select("SELECT * FROM sdy_user WHERE username = #{username}")
    User findUserByUsername(String username);

    @Select("SELECT * FROM sdy_user LIMIT #{0},#{1}")
    List<User> findAllUsers(int page, int rows);

    @Update("UPDATE sdy_user t SET t.password=#{0} WHERE t.username=#{1} AND t.password=#{2}")
    int updatePassword(String username, String oldpassword, String newpasswrod);

    @Select("DELETE FROM sdy_user WHERE username=#{username}")
    int deleteUserByUsername(String username);
}
