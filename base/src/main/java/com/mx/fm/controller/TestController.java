package com.mx.fm.controller;

import com.mx.fm.model.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jack on 17/2/12.
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {
    private static Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping(value = "/test1")
    @ResponseBody
    public Map test1(User user, HttpSession session, HttpServletRequest req, HttpServletResponse resp) {
        logger.debug("test1=" + session.getId());
//        Map map = new HashMap();
//        map.put("key", "123");
//
//        User user1 = new User();
//        user.setNickname("nickname");
//        map.put("nickname", user1);
//        List list = new ArrayList();
//        list.add(user1);
//
//        map.put("list", list);
        try {
            resp.sendRedirect("http://baidu.com");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
