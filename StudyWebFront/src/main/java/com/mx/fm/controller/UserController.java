package com.mx.fm.controller;

import com.mx.fm.model.User;
import com.mx.fm.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jack on 16/5/27.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    private static Logger logger = Logger.getLogger(UserController.class);
    private UserService service = new UserService();

    /**
     * 检测用户名是否已存在
     *
     * @param username
     * @return
     */
    @RequestMapping(value = "/checkUserIsExit", method = RequestMethod.GET)
    @ResponseBody
    public Map checkUserIsExit(String username) {
        logger.debug("checkUserIsExit=" + username);
        return service.checkUserIsExit(username);
    }

    /**
     * 用户登录
     *
     * @param username
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map login(HttpServletRequest request,String username, String password) {
        logger.debug("login=" + username);
        Map map=service.login(username, password);
        if (null!=map&&"2000".equals(map.get("code"))){
            //登录成功
            request.getSession().setAttribute("username",username);
        }
        return service.login(username, password);
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Map register(User user) {
        logger.debug("register");
        Map map = new HashMap();
        map.put("key", "123");

        User user1 = new User();
        user.setNickname("nickname");
        map.put("nickname", user1);
        List list = new ArrayList();
        list.add(user1);

        map.put("list", list);

        return map;
    }


}
