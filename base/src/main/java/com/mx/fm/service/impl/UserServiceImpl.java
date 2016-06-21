package com.mx.fm.service.impl;

import com.mx.fm.dao.IUserDao;
import com.mx.fm.dao.impl.UserDaoImpl;
import com.mx.fm.model.User;
import com.mx.fm.service.IUserService;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by jack on 16/5/27.
 */
public class UserServiceImpl implements IUserService {

    private static Logger logger = Logger.getLogger(UserServiceImpl.class);
    private IUserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

    public void addUser(User user) {

        logger.info("注册的用户信息:"+user);
        int code=userDao.addUser(user);
        if (code>0){

        }
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
