package com.lhh.myconfig;


import com.lhh.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
//@WebFilter("/*")
public class myfilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进来了");
        HttpServletRequest httprequest=(HttpServletRequest) request;
        //判断请求路径中是否包含这个请求地址 包含大于0 不包含等于-1
        System.out.println("httprequest.getRequestURI().indexOf--"+httprequest.getRequestURI().indexOf("login.do"));
        if(httprequest.getRequestURI().indexOf("login.do")>=0){
           User user=(User)httprequest.getSession().getAttribute("user");
            System.out.println("user--"+user);
           if(user == null){
               httprequest.getRequestDispatcher("login.html").forward(request,response);
           }else{
               //放行
               filterChain.doFilter(request,response);
           }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
