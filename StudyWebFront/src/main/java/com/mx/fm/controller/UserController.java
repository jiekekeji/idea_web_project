package com.mx.fm.controller;

import com.mx.fm.constant.UserRoleConstant;
import com.mx.fm.model.User;
import com.mx.fm.model.UserRole;
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
    public Map login(HttpServletRequest request, String username, String password) {
        logger.debug("login=" + username);
        Map map = service.login(username, password);
        if (null != map && "2000".equals(map.get("code"))) {
            //登录成功
            request.getSession().setAttribute("user", map.remove("user"));
        }
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
        return service.register(user);
    }

    /**
     * 获取普通用户
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/findOrdinaryUsers", method = RequestMethod.POST)
    @ResponseBody
    public Map findOrdinaryUsers(int page, int rows) {
        logger.debug("findOrdinaryUsers:" + "page=" + page + " rows" + rows);
        return service.findOrdinaryUsers(page, rows);
    }

    /**
     * 获取管理员
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/findAdmins", method = RequestMethod.POST)
    @ResponseBody
    public Map findAdmins(int page, int rows) {
        logger.debug("findAdmins:" + "page=" + page + " rows" + rows);
        return service.findAdmins(page, rows);
    }

    /**
     * 获取用户的角色
     *
     * @return
     */
    @RequestMapping(value = "/getUserRoles", method = RequestMethod.GET)
    @ResponseBody
    public Map getUserRoles() {
        Map map = new HashMap();
        List roles = new ArrayList();

        UserRole role1 = new UserRole();
        role1.setRoleID(UserRoleConstant.ORDINARY_USER);
        role1.setRoleName("用户");

        UserRole role2 = new UserRole();
        role2.setRoleID(UserRoleConstant.SUPER_ADMIN);
        role2.setRoleName("超级管理员");

        UserRole role3 = new UserRole();
        role3.setRoleID(UserRoleConstant.ORDINARY_ADMIN);
        role3.setRoleName("普通管理员");

        roles.add(role1);
        roles.add(role2);
        roles.add(role3);

        map.put("code",2000);
        map.put("desc","获取成功");
        map.put("roles", roles);
        logger.debug(map);
        return map;
    }

}
