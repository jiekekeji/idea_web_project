package com.mx.fm.service;

import com.mx.fm.dao.UserDao;
import com.mx.fm.model.User;
import org.apache.log4j.Logger;

import java.util.HashMap;
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
}
