package com.mx.fm.mapper;

import com.mx.fm.model.AdminUser;
import com.mx.fm.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 表:sdyweb_admin
 * Created by jack on 16/5/27.
 */
public interface AdminUserMapper {

    @Select("SELECT * FROM sdyweb_admin WHERE username = #{username}")
    AdminUser findUserByUsername(String username);

    @Insert("INSERT INTO sdyweb_admin(username,role,roleid,phonenum,email) " +
            "values(#{username},#{role},#{roleid},#{phonenum},#{email})")
    int addUser(AdminUser user);

    @Select("SELECT * FROM sdyweb_admin LIMIT #{0},#{1}")
    List<AdminUser> findAllUsers(int page, int rows);

    @Update("UPDATE sdyweb_admin t SET t.password=#{0} WHERE t.username=#{1} AND t.password=#{2}")
    int updatePassword(String username, String oldpassword, String newpasswrod);

    @Select("DELETE FROM sdyweb_admin WHERE username=#{username}")
    int deleteUserByUsername(String username);
}
