package com.mx.fm.controller;

import com.mx.fm.constant.UserRoleConstant;
import com.mx.fm.model.User;
import com.mx.fm.model.UserRole;
import com.mx.fm.service.UserService;
import org.apache.log4j.Logger;
import org.apache.log4j.or.ObjectRenderer;
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
     * 检测用户名是否已登录
     *
     * @param username
     * @return
     */
    @RequestMapping(value = "/checkUserIsLogin", method = RequestMethod.GET)
    @ResponseBody
    public Map checkUserIsLogin(HttpServletRequest request,String username) {
        logger.debug("检测用户是否登陆");
        Map<String,Object> map=new HashMap<String, Object>();
        if (null!=request.getSession().getAttribute("user")){
            map.put("code",2000);
            map.put("desc","用户已登陆");
        }else {
            map.put("code",40000);
            map.put("desc","用户未登陆");
        }
        return map;
    }

    /**
     * 用户登录
     *
     * @param username
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map login(HttpServletRequest request, String username, String password) {
        logger.debug("login=" + username);
        Map map = service.login(username, password);
        if (null!=map&&2000==((Integer)map.get("code"))) {
            //登录成功
            request.getSession().setAttribute("user", map.remove("user"));
        }
        logger.debug("登陆用户:"+request.getSession().getAttribute("user"));
        return service.login(username, password);
    }

    /**
     * 未登陆的提示信息
     *
     * @return
     */
    @RequestMapping(value = "/noty2login", method = RequestMethod.GET)
    @ResponseBody
    public Map noty2login() {
        logger.debug("noty2login");
        Map map = new HashMap();
        map.put("code", 4000);
        map.put("desc", "请先登陆");
        return map;
    }

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Map register(User user) {
        logger.debug("register=" + user);
        Map map=service.register(user);
        logger.debug("注册结果:"+map);
        return map;
    }

    /**
     * 获取当前登陆用户
     * @return
     */
    @RequestMapping(value = "/getLoginUser", method = RequestMethod.GET)
    @ResponseBody
    public Map getLoginUser(HttpServletRequest request) {
        logger.debug("获取当前登陆用户");
        Map<String,Object> map=new HashMap<String, Object>();
        User user= (User) request.getSession().getAttribute("user");
        if (null!=user){
            map.put("code",2000);
            map.put("desc","获取成功");
            map.put("user",user);
        }else {
            map.put("code",4000);
            map.put("desc","获取失败");
        }
        logger.debug("user="+user);
        return map;
    }


    /**
     * 获取普通用户列表
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/findOrdinaryUsers", method = RequestMethod.POST)
    @ResponseBody
    public Map findOrdinaryUsers(int page, int rows) {
        logger.debug("findOrdinaryUsers:" + "page=" + page + " rows" + rows);
        Map map=service.findOrdinaryUsers(page, rows);
        logger.debug("用户列表获取结果:"+map);
        return map;
    }

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    @RequestMapping(value = "/findUserByUsername", method = RequestMethod.GET)
    @ResponseBody
    public Map findUserByUsername(String username) {
        logger.debug("findUserByUsername:" + "username=" + username);
        Map map=service.findUserByUsername(username);
        logger.debug("获取用户信息:"+map);
        return map;
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @ResponseBody
    public Map updateUser(User user){
        logger.debug("updateUser:" + "user=" + user);
        Map map=service.updateUser(user);
        logger.debug("更新用户信息:"+map);
        return map;
    }

}
