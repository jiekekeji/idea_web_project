package com.mx.fm.dao;

import com.mx.fm.model.User;

import java.util.List;

/**
 * Created by jack on 16/5/27.
 */
public interface IUserDao {

    User findUserById(int id);

    int addUser(User user);

    List<User> getAllUsers();
}
