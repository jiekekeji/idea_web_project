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

    /**
     * 用户登录
     * @param username
     * @return
     */
    public Map login(String username,String password){
        User user=dao.findUserByUsername(username);
        Map map=new HashMap();
        if (null==user){
            map.put("code","4000");
            map.put("desc","登录失败");
            return map;
        }

        if (null!=password&&password.equals(user.getPassword())){
            map.put("code","2000");
            map.put("desc","登录成功");
            return map;
        }
        return map;
    }
}
