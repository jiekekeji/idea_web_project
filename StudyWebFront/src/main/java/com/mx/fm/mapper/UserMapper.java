package com.mx.fm.mapper;

import com.mx.fm.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 表:sdyweb_user
 * Created by jack on 16/5/27.
 */
public interface UserMapper {

    @Select("SELECT * FROM sdyweb_user WHERE username = #{username}")
    User findUserByUsername(String username);

    @Insert("INSERT INTO sdyweb_user(username,nickname,password,phonenum,email,gender) " +
            "values(#{username},#{nickname},#{password},#{phonenum},#{email},#{gender})")
    int addUser(User user);

    @Select("SELECT * FROM sdyweb_user LIMIT #{0},#{1}")
    List<User> findAllUsers(int page,int rows);

    @Update("UPDATE sdyweb_user t SET t.password=#{0} WHERE t.username=#{1} AND t.password=#{2}")
    int updatePassword(String username,String oldpassword,String newpasswrod);
}
