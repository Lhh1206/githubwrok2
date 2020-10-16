package com.lhh.myconfig;


import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RightControl extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        if (uri.endsWith("login.do") || uri.endsWith("login.html") || uri.endsWith("regist.html")) {
            //登陆请求
            return true;
        } else {
            Object obj = request.getSession().getAttribute("user");
            System.out.println("obj--"+obj);
            if (obj != null) {
                return true;
            } else {
                System.out.println("没登录,送你回登陆页面,走你");
                response.sendRedirect("login.html");
                return false;
            }
        }
    }
}
