package com.mx.fm.controller;

import com.mx.fm.model.User;
import com.mx.fm.service.IUserService;
import com.mx.fm.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jack on 16/5/27.
 */
@Controller
@RequestMapping(value ="/user")
public class UserController {

    private static Logger logger = Logger.getLogger(UserController.class);
    private IUserService service = new UserServiceImpl();

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String  index(){

        return "index";
    }

    @RequestMapping(value="nice",method = RequestMethod.GET)
    public  String nice(Model model){
        model.addAttribute("result","hahaha 第一个参数");
        return "nice";
    }

    @RequestMapping(value="/register",method = RequestMethod.POST)
    @ResponseBody
    public Map register(User user){
        logger.debug("register");
        Map map=new HashMap();
        map.put("key","123");

        User user1=new User();
        user.setNickname("nickname");
        map.put("nickname",user1);
        List list=new ArrayList();
        list.add(user1);

        map.put("list",list);

        return map;
    }


}
