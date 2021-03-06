package com.mx.fm.service;

import com.mx.fm.dao.UserDao;
import com.mx.fm.model.User;
import com.mx.fm.utils.TextUtils;
import org.apache.log4j.Logger;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jack on 16/7/10.
 */
public class UserService {
    private static Logger logger = Logger.getLogger(UserService.class);

    private UserDao dao = new UserDao();

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    public Map registerUser(User user) {
        return null;
    }

    /**
     * 查看用户是否已存在
     *
     * @return
     */
    public Map checkUserIsExit(String username) {
        Map map = new HashMap();
        if (null != dao.findUserByUsername(username)) {
            map.put("code", 1000);
            map.put("desc", "用户已存在");
            return map;
        }

        map.put("code", 1001);
        map.put("desc", "用户不存在");
        return map;
    }

    /**
     * 用户登录
     *
     * @param username
     * @return
     */
    public Map login(String username, String password) {
        User user = dao.findUserByUsername(username);
        Map map = new HashMap();
        if (null == user) {
            map.put("code", 4000);
            map.put("desc", "登录失败");
            return map;
        }

        if (null != password && password.equals(user.getPassword())) {
            map.put("code", 2000);
            map.put("desc", "登录成功");
            map.put("user", user);
            return map;
        }
        return map;
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    public Map register(User user) {
        Map map = new HashMap();
        if (null == user || TextUtils.isEmpty(user.getUsername()) || TextUtils.isEmpty(user.getPassword())) {
            map.put("code", "4000");
            map.put("desc", "注册失败，信息不完整");
            return map;
        }

        int code = dao.addUser(user);
        if (code == 0) {
            map.put("code", "4000");
            map.put("desc", "注册失败");
            return map;
        }

        map.put("code", 2000);
        map.put("desc", "注册成功");
        return map;

    }


    /**
     * 获取用户信息
     *
     * @param username
     * @return
     */
    public Map getUserInfo(String username) {
        Map map = new HashMap();
        User user = dao.findUserByUsername(username);
        map.put("map", map);
        return map;
    }


    /**
     * 获取普通用户
     *
     * @param page
     * @param rows
     * @return
     */
    public Map findOrdinaryUsers(int page, int rows) {
        Map map = new HashMap();
        List<User> users = dao.findAllUsers(page, rows);
        map.put("users", users);
        return map;
    }

    /**
     * 根据用户用查询用户信息
     *
     * @param username
     * @return
     */
    public Map findUserByUsername(String username) {
        Map map = new HashMap();
        User user = dao.findUserByUsername(username);
        if (null != user) {
            map.put("code", 2000);
            map.put("desc", "查询成功");
            map.put("user", user);
            return map;
        }
        map.put("code", 4000);
        map.put("desc", "查询失败");
        return map;
    }

    /**
     * 修改 昵称,电话号,QQ号,头像,微信,邮箱,自我介绍
     *
     * @param user
     * @return
     */
    public Map updateUser(User user) {
        int code = dao.updateUser(user);
        Map map = new HashMap();
        if (code > 0) {
            map.put("code", 2000);
            map.put("desc", "更新成功");
            return map;
        }
        map.put("code", 4000);
        map.put("desc", "更新失败");
        return map;
    }

    /**
     * 查找用户
     *
     * @param phonenum
     * @return
     */
    public Map findUserByPhonenum(String phonenum, int page, int rows) {
        Map map = new HashMap();
        List<User> users = dao.findUserByPhonenum(phonenum, page, rows);
        map.put("users", users);
        return map;
    }

    /**
     * 查找用户
     *
     * @param username
     * @param page
     * @param rows
     * @return
     */
    public Map findUsersByUsername(String username, int page, int rows) {
        Map map = new HashMap();
        List<User> users = dao.findUsersByUsername(username, page, rows);
        map.put("users", users);
        return map;
    }


}
