package com.mx.fm.controller;

import com.mx.fm.model.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @ResponseBody
    public Map checkUserIsExit(String username,String password) {
        logger.debug("register=" + username);
        User user1=new User();
        user1.setId(123);
        user1.setUsername("jack");
        user1.setPhonenum("18025232352");

        User user2=new User();
        user2.setId(321);
        user2.setUsername("rose");
        user2.setPhonenum("18532562535");

        List<User> users=new ArrayList<User>();
        users.add(user1);
        users.add(user2);

        Map map=new HashMap();
        map.put("code",2000);
        map.put("users",users);
        return map;
    }


}
