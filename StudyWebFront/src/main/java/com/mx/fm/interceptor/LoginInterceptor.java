package com.mx.fm.interceptor;

import com.mx.fm.controller.UserController;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jack on 16/7/11.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter{
    private static Logger logger = Logger.getLogger(LoginInterceptor.class);

    private static final String[] IGNORE_URI = {"/login.jsp", "/Login/","backui/","frontui/"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
}
