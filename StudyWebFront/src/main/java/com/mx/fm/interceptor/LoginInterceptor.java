package com.mx.fm.interceptor;

import com.mx.fm.controller.UserController;
import com.mx.fm.model.User;
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

    //不执行拦截的URL
    private static final String[] IGNORE_URI = {"/user/noty2login","/user/login"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug("preHandle");
        //默认不放行
        boolean flag = false;
        //判断是否是放行的URL
        String url = request.getRequestURL().toString();
        for (String s : IGNORE_URI) {
            if (url.contains(s)) {
                flag = true;
                break;
            }
        }

        //如果不是放行的，检测是否已登陆
        if (!flag) {
            if (null!=request.getSession().getAttribute("user")){
                //放行
                flag = true;
            }else{
                //跳转到提示登陆
                request.getRequestDispatcher("/user/noty2login").forward(request, response);
            }
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.debug("postHandle");
        super.postHandle(request, response, handler, modelAndView);
    }
}
