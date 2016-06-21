package com.mx.fm.service;

import com.mx.fm.model.User;

import java.util.List;

/**
 * Created by jack on 16/5/27.
 */
public interface IUserService {
    User findUserById(int id);
    void addUser(User user);
    List<User> getAllUsers();
}
