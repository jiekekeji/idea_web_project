package com.mx.fm.mapper;

import com.mx.fm.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by jack on 16/5/27.
 */
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User findUserById(int id);

    @Insert("insert into user(account,password) values(#{account},#{password})")
    int addUser(User user);

    @Select("select * from user")
    List<User> getAllUsers();
}
