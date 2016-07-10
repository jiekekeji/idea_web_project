package com.mx.fm.mapper;

import com.mx.fm.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

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

    @Select("SELECT (id,username,nickname,password,phonenum,email,gender) FROM sdyweb_user LIMIT #{page},#{rows}")
    List<User> findAllUsers(String page,String rows);
}
